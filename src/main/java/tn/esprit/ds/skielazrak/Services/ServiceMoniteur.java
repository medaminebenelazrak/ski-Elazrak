package tn.esprit.ds.skielazrak.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skielazrak.Entities.Cours;
import tn.esprit.ds.skielazrak.Entities.Moniteur;
import tn.esprit.ds.skielazrak.Repositories.CoursRepository;
import tn.esprit.ds.skielazrak.Repositories.MoniteurRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ServiceMoniteur implements IServiceMoniteur{
    private MoniteurRepository moniteurRepository;
    private CoursRepository coursRepository;

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cours cours =coursRepository.findById(numCourse).orElse(null);
        Set<Cours> courses = new HashSet<>();
        courses.add(cours);
        moniteur.setCours(courses);

        return moniteurRepository.save(moniteur);
    }
}
