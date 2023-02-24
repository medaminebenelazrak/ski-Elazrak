package tn.esprit.ds.skielazrak.Services;

import tn.esprit.ds.skielazrak.Entities.Cours;

import java.util.List;

public interface ICoursService {
    List<Cours> retrieveAllCours();
    Cours addCours (Cours cours);
    void removeCours (Long numCours);
    Cours retrieveCours (Long numCours);
    Cours updateCours (Cours cours);
}
