package tn.esprit.ds.skielazrak.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skielazrak.Entities.Piste;
import tn.esprit.ds.skielazrak.Repositories.PisteRepository;

import java.util.List;
@Service
public class PisteService implements IPisteService{
    @Autowired
    PisteRepository pisteRepository;
    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public void removePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }
    @Override
    public Piste updatePiste(Piste piste){
        return pisteRepository.save(piste);
    }
}
