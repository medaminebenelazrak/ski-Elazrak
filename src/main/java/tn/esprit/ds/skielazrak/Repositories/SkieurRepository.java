package tn.esprit.ds.skielazrak.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.skielazrak.Entities.Abonnement;
import tn.esprit.ds.skielazrak.Entities.Skieur;
import tn.esprit.ds.skielazrak.Entities.TypeAbonnement;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Long> {
    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbonnement);
    Skieur findByAbonnement(Abonnement abonnement);
}

