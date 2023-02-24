package tn.esprit.ds.skielazrak.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skielazrak.Entities.Inscription;
import tn.esprit.ds.skielazrak.Services.IInscriptionService;

import java.util.List;
@RestController
@RequestMapping("/inscription")
public class InscriptionController {
    @Autowired
    IInscriptionService inscriptionService;
    @GetMapping
    public List<Inscription> getAll(){
        return inscriptionService.retrieveAllInscriptions();
    }
    @GetMapping("/{numInscription}")
    public Inscription retrieveInscription (@PathVariable Long numInscription){
        return inscriptionService.retrieveInscription(numInscription);
    }
    @PostMapping
    public Inscription postInscription(@RequestBody Inscription inscription){
        return inscriptionService.addInscription(inscription);
    }
    @PutMapping
    public Inscription updateInscription(@RequestBody Inscription inscription){
        return inscriptionService.updateInscription(inscription);
    }
    @DeleteMapping("/{id}")
    public void removeInscription (@PathVariable(name = "id") Long numInscription){
        inscriptionService.removeInscription(numInscription);
    }
}
