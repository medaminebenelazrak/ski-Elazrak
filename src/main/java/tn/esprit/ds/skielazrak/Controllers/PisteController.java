package tn.esprit.ds.skielazrak.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skielazrak.Entities.Piste;
import tn.esprit.ds.skielazrak.Services.IServicePiste;

import java.util.List;

@RestController
@AllArgsConstructor
public class PisteController {
    private IServicePiste iServicePiste;
    @PostMapping("/ajoutt")
    public Piste ajout(@RequestBody Piste piste) {
        return iServicePiste.add(piste);
    }

    @PostMapping("/updaas")
    public Piste update(@RequestBody Piste piste) {
        return iServicePiste.update(piste);
    }

    @GetMapping("/piste/{idsss}")
    public Piste findOne(@PathVariable("idsss") Long idPiste) {
        return iServicePiste.findOne(idPiste);

    }

    @GetMapping("/findAlk")
    public List<Piste> findAll() {
        return iServicePiste.findAll();
    }

    @DeleteMapping("/zarga/{idqs}")
    public void delete(@PathVariable ("idqs") Long idPiste) {
        iServicePiste.delete(idPiste);

    }
}
