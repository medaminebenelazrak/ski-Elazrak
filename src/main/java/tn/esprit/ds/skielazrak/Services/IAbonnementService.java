package tn.esprit.ds.skielazrak.Services;

import tn.esprit.ds.skielazrak.Entities.Abonnement;

import java.util.List;

public interface IAbonnementService {
    List<Abonnement> retrieveAllAbonnements();
    Abonnement addAbonnement(Abonnement abonnement);
    void removeAbonnement (Long numAbon);
    Abonnement retrieveAbonnement (Long numAbon);
    Abonnement updateAbonnement(Abonnement abonnement);
}
