package tn.esprit.ds.skielazrak.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skielazrak.Entities.Cours;
import tn.esprit.ds.skielazrak.Services.ICoursService;

import java.util.List;
@RestController
@RequestMapping("/cours")
public class CoursController {
    @Autowired
    ICoursService coursService;
    @GetMapping
    public List<Cours> getAll(){
        return coursService.retrieveAllCours();
    }
    @GetMapping("/{numCours}")
    public Cours retrieveCours (@PathVariable Long numCours){
        return coursService.retrieveCours(numCours);
    }
    @PostMapping
    public Cours postCours(@RequestBody Cours cours){
        return coursService.addCours(cours);
    }
    @PutMapping
    public Cours updateCours(@RequestBody Cours cours){
        return coursService.updateCours(cours);
    }
    @DeleteMapping("/{id}")
    public void removeCours (@PathVariable(name = "id") Long numCours){
        coursService.removeCours(numCours);
    }
}
