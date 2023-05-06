package tn.esprit.ds.skielazrak.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skielazrak.Entities.Cours;
import tn.esprit.ds.skielazrak.Entities.Support;
import tn.esprit.ds.skielazrak.Services.IServiceCours;

import java.util.List;

@RestController
@AllArgsConstructor

public class CoursController {
    private IServiceCours iServiceCours;
    @PostMapping("/adddd")
    public Cours ajout(@RequestBody Cours cours) {
        return iServiceCours.add(cours);
    }

    @PostMapping("/updatee")
    public Cours update(@RequestBody Cours cours) {
        return iServiceCours.update(cours);
    }

    @GetMapping("/cours/{ids}")
    public Cours findOne(@PathVariable("ids") Long numCours) {
        return iServiceCours.findOne(numCours);

    }

    @GetMapping("/findAlll")
    public List<Cours> findAll() {
        return iServiceCours.findAll();
    }

    @DeleteMapping("/cour/{idd}")
    public void delete(@PathVariable ("idd") Long numCours) {
        iServiceCours.delete(numCours);

    }
    @GetMapping("/numweeks/{numInstructor}/{support}")
    public List<Integer> numWeeksCourseOfInstructorBySupport(@PathVariable Long numInstructor,@PathVariable Support support) {return  iServiceCours.numWeeksCourseOfInstructorBySupport(numInstructor,support);}
}
