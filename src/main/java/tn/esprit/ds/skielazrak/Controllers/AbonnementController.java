package tn.esprit.ds.skielazrak.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skielazrak.Entities.Abonnement;
import tn.esprit.ds.skielazrak.Entities.TypeAbonnement;
import tn.esprit.ds.skielazrak.Services.IServiceAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class AbonnementController {
    private IServiceAbonnement iServiceAbonnement;

    @PostMapping("/add")
    public Abonnement ajout(@RequestBody Abonnement abonnement) {
        return iServiceAbonnement.add(abonnement);
    }

    @PostMapping("/update")
    public Abonnement update(@RequestBody Abonnement abonnement) {
        return iServiceAbonnement.update(abonnement);
    }

    @GetMapping("/{id}")
    public Abonnement findOne(@PathVariable ("id") Long idAbonnement) {
        return iServiceAbonnement.findOne(idAbonnement);

    }

    @GetMapping("/findAll")
    public List<Abonnement> findAll() {
        return iServiceAbonnement.findAll();
    }

    @DeleteMapping("/{idA}")
    public void delete(@PathVariable ("idA") Long idAbonnement) {
        iServiceAbonnement.delete(idAbonnement);

    }
    @GetMapping("/getsubscription/{type}")
    public Set<Abonnement> getSubscriptionByType(@PathVariable("type") TypeAbonnement type) {return  iServiceAbonnement.getSubscriptionByType(type);}
    @GetMapping("/getbydate/{startDate}/{endDate}")
    public List<Abonnement> retrieveSubscriptionsByDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {return  iServiceAbonnement.retrieveSubscriptionsByDates(startDate,endDate);}
}
