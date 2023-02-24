package tn.esprit.ds.skielazrak.Services;

import tn.esprit.ds.skielazrak.Entities.Inscription;

import java.util.List;

public interface IInscriptionService {
    List<Inscription> retrieveAllInscriptions();
    Inscription addInscription (Inscription inscription);
    void removeInscription (Long numInscription);
    Inscription retrieveInscription (Long numInscription);
    Inscription updateInscription(Inscription inscription);
}
