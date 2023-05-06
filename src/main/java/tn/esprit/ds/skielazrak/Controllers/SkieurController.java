package tn.esprit.ds.skielazrak.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skielazrak.Entities.Skieur;
import tn.esprit.ds.skielazrak.Entities.TypeAbonnement;
import tn.esprit.ds.skielazrak.Services.IServiceSkieur;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("skieur")
public class SkieurController {
    private IServiceSkieur iServiceSkieur;
    @PostMapping("/ajoutit")
    public Skieur ajout(@RequestBody Skieur skieur) {
        return iServiceSkieur.add(skieur);
    }

    @PostMapping("/updaasi")
    public Skieur update(@RequestBody Skieur skieur) {
        return iServiceSkieur.update(skieur);
    }

    @GetMapping("/skieur/{idsssi}")
    public Skieur findOne(@PathVariable("idsssi") Long numSkieur) {
        return iServiceSkieur.findOne(numSkieur);

    }

    @GetMapping("/findAlki")
    public List<Skieur> findAll() {
        return iServiceSkieur.findAll();
    }

    @DeleteMapping("/skieuer/{idqsi}")
    public void delete(@PathVariable ("idqsi") Long numSkieur) {
        iServiceSkieur.delete(numSkieur);

    }
    @PostMapping("/assignski/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable ("numSkieur") Long numSkieur,@PathVariable("numPiste") Long numPiste) {return  iServiceSkieur.assignSkierToPiste(numSkieur,numPiste);}
    @PostMapping("/addskieueur2/{numCourse}")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skier,@PathVariable("numCourse") Long numCourse) {return  iServiceSkieur.addSkierAndAssignToCourse(skier,numCourse);}
    @GetMapping("/retreiveskiebysubsc/{typeAbonnement}")
    public List<Skieur> retrieveSkiersBySubscriptionType(@PathVariable("typeAbonnement") TypeAbonnement typeAbonnement) {return iServiceSkieur.retrieveSkiersBySubscriptionType(typeAbonnement);}
}
