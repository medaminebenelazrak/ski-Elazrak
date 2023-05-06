package tn.esprit.ds.skielazrak.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skielazrak.Entities.Cours;
import tn.esprit.ds.skielazrak.Entities.Inscription;
import tn.esprit.ds.skielazrak.Entities.Skieur;
import tn.esprit.ds.skielazrak.Entities.TypeCours;
import tn.esprit.ds.skielazrak.Repositories.CoursRepository;
import tn.esprit.ds.skielazrak.Repositories.InscriptionRepository;
import tn.esprit.ds.skielazrak.Repositories.SkieurRepository;

import java.util.List;
@Service
@AllArgsConstructor

public class ServiceInscription implements IServiceInscription{
    private CoursRepository cooursRepository;
    private SkieurRepository skieurRepository;
    private InscriptionRepository inscriptionRepository;
    @Override
    public Inscription add(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription update(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription findOne(Long numInscription) {
        return inscriptionRepository.findById(numInscription).orElse(null);

    }

    @Override
    public List<Inscription> findAll() {
        return inscriptionRepository.findAll();
    }

    @Override
    public void delete(Long numInscription) {
        inscriptionRepository.deleteById(numInscription);

    }

    @Override
    public Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkier) {
        Skieur skieur=skieurRepository.findById(numSkier).orElse(null);
        inscription.setSkieur(skieur);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Inscription inscription =inscriptionRepository.findById(numRegistration).orElse(null);
        Cours cours = cooursRepository.findById(numCourse).orElse(null);
        inscription.setCours(cours);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Cours cours = cooursRepository.findById(numCours).orElse(null);

        if (cours.typeCours == TypeCours.COLLECTIF_ENFANT || cours.typeCours == TypeCours.COLLECTIF_ADULTE) {
            if (cours.getInscriptions().size() >= 6) {
                System.out.println("Le nombre maximal d'inscriptions pour ce cours a été atteint.");
            }
        }

        inscription.setCours(cours);
        inscription.setSkieur(skieur);




        return inscriptionRepository.save(inscription);

    }
}
