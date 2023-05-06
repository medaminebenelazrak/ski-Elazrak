package tn.esprit.ds.skielazrak.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skielazrak.Entities.Piste;
import tn.esprit.ds.skielazrak.Repositories.PsiteRepository;

import java.util.List;

@Service
@AllArgsConstructor


public class ServicePiste implements  IServicePiste{
    private PsiteRepository pisteRepository;
    @Override
    public Piste add(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste update(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste findOne(Long numInscription) {
        return pisteRepository.findById(numInscription).orElse(null);

    }

    @Override
    public List<Piste> findAll() {
        return pisteRepository.findAll();
    }

    @Override
    public void delete(Long numInscription) {
        pisteRepository.deleteById(numInscription);

    }
}
