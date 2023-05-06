package tn.esprit.ds.skielazrak.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skielazrak.Entities.Cours;
import tn.esprit.ds.skielazrak.Entities.Support;
import tn.esprit.ds.skielazrak.Repositories.CoursRepository;
import tn.esprit.ds.skielazrak.Repositories.MoniteurRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class ServiceCours implements IServiceCours{
    private MoniteurRepository moniteurRepository;
    private CoursRepository coursRepository;

    @Override
    public Cours add(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours update(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours findOne(Long idAbonnement) {
        return coursRepository.findById(idAbonnement).orElse(null);

    }

    @Override
    public List<Cours> findAll() {
        return coursRepository.findAll();
    }

    @Override
    public void delete(Long numCours) {
        coursRepository.deleteById(numCours);

    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        List<Integer> numweeks = new ArrayList<>();
        for (Cours cours:coursRepository.findByMoniteurNumMonAndSupport(numInstructor,support)){
            numweeks.add(Math.toIntExact(cours.getNumCours()));
        }
        return numweeks;


    }

}
