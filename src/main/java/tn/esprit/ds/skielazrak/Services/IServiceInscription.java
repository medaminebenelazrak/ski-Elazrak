package tn.esprit.ds.skielazrak.Services;

import tn.esprit.ds.skielazrak.Entities.Inscription;

import java.util.List;

public interface IServiceInscription {
    public Inscription add (Inscription inscription);
    public Inscription update (Inscription inscription);
    public Inscription findOne (Long numInscription);
    public List<Inscription> findAll ();
    public void delete (Long numInscription);
    Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkier);
    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) ;
    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);
}
