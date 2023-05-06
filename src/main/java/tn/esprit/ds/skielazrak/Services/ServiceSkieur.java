package tn.esprit.ds.skielazrak.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.ds.skielazrak.Entities.*;
import tn.esprit.ds.skielazrak.Repositories.CoursRepository;
import tn.esprit.ds.skielazrak.Repositories.InscriptionRepository;
import tn.esprit.ds.skielazrak.Repositories.PsiteRepository;
import tn.esprit.ds.skielazrak.Repositories.SkieurRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j

public class ServiceSkieur implements IServiceSkieur{
    private InscriptionRepository inscriptionRepository;
    private CoursRepository coursRepository;
    private  PsiteRepository psiteRepository;
    private SkieurRepository skieurRepository;
    @Override
    public Skieur add(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur update(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur findOne(Long numInscription) {
        return skieurRepository.findById(numInscription).orElse(null);

    }

    @Override
    public List<Skieur> findAll() {
        return skieurRepository.findAll();
    }

    @Override
    public void delete(Long numInscription) {
        skieurRepository.deleteById(numInscription);

    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Piste piste=psiteRepository.findById(numPiste).orElse(null);
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null);
        try{
            skieur.getPistes().add(piste);
            piste.getSkieurs().add(skieur); //Bi-directional so we need to add for both.
            log.info("after add");
        }catch (NullPointerException exception){
            log.info("in the exception");
            Set<Piste> pisteSet = new HashSet<>();
            pisteSet.add(piste);
            skieur.setPistes(pisteSet);
        }
        log.info("after the exception");
        return skieurRepository.save(skieur);

    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse) {
        Assert.notNull(skier.getAbonnement(),"Abonnement must not be empty"); //Je vérifie si l'abobjet abonnement existe
        Assert.notNull(skier.getInscriptions(),"Inscriptions must not be empty"); // Je vérifie l'existance de l'objet Insctiption
        Set<Inscription> inscriptions=skier.getInscriptions();
        inscriptions.forEach(inscription ->  { //Je parcoue la liste des inscriptions et je m'assure que chaque inscri contient un cours
            Assert.notNull(inscription.getCours().getNumCours(), " Cours must be entered !!");
            Cours cours=coursRepository.findById(numCourse).orElse(null);
            Assert.notNull(cours, " No cours found with this id!");
            inscription.setCours(cours); //Inscription contient un seul cours donc l'inscription gérera la relation et affectera l'inscription au cours
            inscription.setSkieur(skier);
            inscriptionRepository.save(inscription);
            //Exception handler
        });
        skieurRepository.save(skier);//Je l'insère dans cette partie ( en dehors de la boucle for vu qu'il ne va pas enregistrer les ctrls de saisie et j'implémenterai une autre boucle for
        //Pas de différence entre save and saveandflush juste la notification instantannée pour flush
        skier.getInscriptions().forEach(inscription -> {
            inscription.setSkieur(skier);
            inscriptionRepository.save(inscription);
        });
        return skier;




    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnementTypeAbon(typeAbonnement);
    }
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Scheduled(cron = "0 0 0 1 * *") // Run at midnight on the first day of each month
    /*"0 0 0" represents the time of day (hour, minute, and second) when the method should run, in 24-hour format. In this case, it's midnight (00:00:00).
"1" represents the day of the month on which the method should run. In this case, it's the first day of the month.
"*" represents the other fields in the cron expression, which are the month, day of the week, and year. The asterisk means "any value", so the method will run regardless of the month, day of the week, or year.*/
    public void showMonthlyRecurringRevenue() {
        LocalDate today = LocalDate.now();
        LocalDate oneMonthAgo = today.minusMonths(1);

        List<Abonnement> abonnements = entityManager.createQuery("SELECT a FROM Abonnement a WHERE a.dateDebut <= :oneMonthAgo AND a.dateFin >= :today", Abonnement.class)
                .setParameter("oneMonthAgo", oneMonthAgo)
                .setParameter("today", today)
                .getResultList();

        float revenue = 0;
        for (Abonnement abonnement : abonnements) {
            revenue += abonnement.getPrixAbon();
        }

        System.out.println("Monthly recurring revenue for " + oneMonthAgo.getMonth() + " is " + revenue);

    }


}
