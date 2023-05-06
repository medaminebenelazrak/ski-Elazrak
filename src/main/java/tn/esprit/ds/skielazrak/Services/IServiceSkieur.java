package tn.esprit.ds.skielazrak.Services;

import tn.esprit.ds.skielazrak.Entities.Skieur;
import tn.esprit.ds.skielazrak.Entities.TypeAbonnement;

import java.util.List;

public interface IServiceSkieur {
    public Skieur add (Skieur skieur);
    public Skieur update (Skieur skieur);
    public Skieur findOne (Long numSkieur);
    public List<Skieur> findAll ();
    public void delete (Long numSkieur);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse);
    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
    public void showMonthlyRecurringRevenue();
}
