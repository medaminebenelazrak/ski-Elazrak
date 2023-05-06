package tn.esprit.ds.skielazrak.Services;

import tn.esprit.ds.skielazrak.Entities.Cours;
import tn.esprit.ds.skielazrak.Entities.Support;

import java.util.List;

public interface IServiceCours {
    public Cours add (Cours cours) ;
    public Cours update (Cours cours);
    public Cours findOne (Long numCours);
    public List<Cours> findAll ();
    public void delete (Long idAbonnement);
    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
}
