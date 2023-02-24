package tn.esprit.ds.skielazrak.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skielazrak.Entities.Moniteur;
import tn.esprit.ds.skielazrak.Services.IMoniteurService;

import java.util.List;
@RestController
@RequestMapping("/moniteur")
public class MoniteurController {
    @Autowired
    IMoniteurService moniteurService;
    @GetMapping
    public List<Moniteur> getAll(){
        return moniteurService.retrieveAllMoniteurs();
    }
    @GetMapping("/{numMoniteur}")
    public Moniteur retrieveMoniteur (@PathVariable Long numMoniteur){
        return moniteurService.retrieveMoniteur(numMoniteur);
    }
    @PostMapping
    public Moniteur postMoniteur(@RequestBody Moniteur moniteur){
        return moniteurService.addMoniteur(moniteur);
    }
    @PutMapping
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur){
        return moniteurService.updateMoniteur(moniteur);
    }
    @DeleteMapping("/{id}")
    public void removeMoniteur (@PathVariable(name = "id") Long numMoniteur){
        moniteurService.removeMoniteur(numMoniteur);
    }
}
