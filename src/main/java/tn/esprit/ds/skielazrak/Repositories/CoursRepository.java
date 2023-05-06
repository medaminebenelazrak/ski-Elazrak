package tn.esprit.ds.skielazrak.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.skielazrak.Entities.*;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long> {
    List<Cours> findByMoniteurNumMonAndSupport(Long numMoniteur,Support support);
}
