package tn.esprit.ds.skielazrak.Services;

import tn.esprit.ds.skielazrak.Entities.Moniteur;

public interface IServiceMoniteur {
    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);
}
