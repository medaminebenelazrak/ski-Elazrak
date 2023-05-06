package tn.esprit.ds.skielazrak.Services;

import tn.esprit.ds.skielazrak.Entities.Abonnement;
import tn.esprit.ds.skielazrak.Entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IServiceAbonnement {

    public Abonnement add (Abonnement abonnement);
    public Abonnement update (Abonnement abonnement);
    public Abonnement findOne (Long idAbonnement);
    public List<Abonnement> findAll ();
    public void delete (Long idAbonnement);
    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
    public void retrieveSubscriptions();
}
