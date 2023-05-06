package tn.esprit.ds.skielazrak.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skielazrak.Entities.Inscription;
import tn.esprit.ds.skielazrak.Services.IServiceInscription;

import java.util.List;

@RestController
@AllArgsConstructor
public class InscriptionController {
    private IServiceInscription iServiceInscription;
    @PostMapping("/ajouttt")
    public Inscription ajout(@RequestBody Inscription inscription) {
        return iServiceInscription.add(inscription);
    }

    @PostMapping("/upda")
    public Inscription update(@RequestBody Inscription inscription) {
        return iServiceInscription.update(inscription);
    }

    @GetMapping("/inscri/{idss}")
    public Inscription findOne(@PathVariable("idss") Long numInscription) {
        return iServiceInscription.findOne(numInscription);

    }

    @GetMapping("/findAl")
    public List<Inscription> findAll() {
        return iServiceInscription.findAll();
    }

    @DeleteMapping("/insc/{idq}")
    public void delete(@PathVariable ("idq") Long numInscription) {
        iServiceInscription.delete(numInscription);

    }
    @PostMapping("/ajoutinscription/{numSkier}")
    public Inscription addRegistrationAndAssignToSkier(@RequestBody Inscription inscription,@PathVariable("numSkier") Long numSkier) {
        return iServiceInscription.addRegistrationAndAssignToSkier(inscription,numSkier);
    }
    @PostMapping("/assignregist/{numRegistration}/{numCourse}")
    public Inscription assignRegistrationToCourse(@PathVariable("numRegistration") Long numRegistration,@PathVariable("numCourse") Long numCourse){
        return iServiceInscription.assignRegistrationToCourse(numRegistration,numCourse);
    }
    @PostMapping("/addregistration3/{numSkieur}/{numCours}")
    public Inscription addRegistrationAndAssignToSkierAndCourse(@RequestBody Inscription inscription,@PathVariable("numSkieur") Long numSkieur,@PathVariable("numCours") Long numCours) {return  iServiceInscription.addRegistrationAndAssignToSkierAndCourse(inscription,numSkieur,numCours);}
}
