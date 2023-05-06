package tn.esprit.ds.skielazrak.Services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skielazrak.Entities.Abonnement;
import tn.esprit.ds.skielazrak.Entities.Skieur;
import tn.esprit.ds.skielazrak.Entities.TypeAbonnement;
import tn.esprit.ds.skielazrak.Repositories.AbonnementRepository;
import tn.esprit.ds.skielazrak.Repositories.SkieurRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ServiceAbonnementImpl implements IServiceAbonnement{
    private SkieurRepository skieurRepository;
    private AbonnementRepository abonnementRepository;

    @Override
    public Abonnement add(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement update(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement findOne(Long idAbonnement) {
         return abonnementRepository.findById(idAbonnement).orElse(null);

    }

    @Override
    public List<Abonnement> findAll() {
        return abonnementRepository.findAll();
    }

    @Override
    public void delete(Long idAbonnement) {
        abonnementRepository.deleteById(idAbonnement);

    }

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        return abonnementRepository.findByTypeAbonOrderByDateDebut(type);
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.findAbonnementByDateDebutAndDateFin(startDate,endDate);
    }
    @Override
    @Scheduled(fixedRate = 604800000) // exécuté toutes les semaines (7 jours = 604800000 ms)
    public void retrieveSubscriptions() {
        LocalDate now = LocalDate.now();
        LocalDate endDate =now.plusDays(7) ;
        List<Abonnement> abonnements = abonnementRepository.findAbonnementByDateDebutAndDateFin(now, endDate);
        for (Abonnement abonnement : abonnements) {
            Skieur skieur = skieurRepository.findByAbonnement(abonnement);
            System.out.println("Abonnement " + abonnement.getNumAbon() + " du skieur " +
                    skieur.getNomS() + " "  + " (numSkieur " + skieur.getNumSkieur() +
                    ") se termine le " + abonnement.getDateFin());
        }

    }



}
