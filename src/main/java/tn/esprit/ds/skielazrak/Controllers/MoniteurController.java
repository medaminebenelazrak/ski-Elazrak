package tn.esprit.ds.skielazrak.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ds.skielazrak.Entities.Moniteur;
import tn.esprit.ds.skielazrak.Services.IServiceMoniteur;

@RestController
@AllArgsConstructor
public class MoniteurController {
    private IServiceMoniteur iServiceMoniteur;
    @PostMapping("/addinstructor/{numCourse}")
    public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur,@PathVariable("numCourse") Long numCourse) {return  iServiceMoniteur.addInstructorAndAssignToCourse(moniteur,numCourse);}
}
