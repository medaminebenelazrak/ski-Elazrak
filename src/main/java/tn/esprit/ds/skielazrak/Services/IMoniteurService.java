package tn.esprit.ds.skielazrak.Services;

import tn.esprit.ds.skielazrak.Entities.Moniteur;

import java.util.List;

public interface IMoniteurService {
    List<Moniteur> retrieveAllMoniteurs();
    Moniteur addMoniteur (Moniteur moniteur);
    void removeMoniteur (Long numMoniteur);
    Moniteur retrieveMoniteur (Long numMoniteur);
    Moniteur updateMoniteur(Moniteur moniteur);
}
