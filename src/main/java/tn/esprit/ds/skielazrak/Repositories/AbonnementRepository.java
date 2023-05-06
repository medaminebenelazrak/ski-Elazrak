package tn.esprit.ds.skielazrak.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.skielazrak.Entities.Abonnement;
import tn.esprit.ds.skielazrak.Entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
    //PagingAndSortingRepository: feha ken pagination et trie
    //CrudRepository : fiha ken crud
    Set<Abonnement> findByTypeAbonOrderByDateDebut(TypeAbonnement typeAbonnement);
    List<Abonnement> findAbonnementByDateDebutAndDateFin(LocalDate startDate, LocalDate endDate);


}
