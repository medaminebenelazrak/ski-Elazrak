package tn.esprit.ds.skielazrak.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skielazrak.Entities.Moniteur;
import tn.esprit.ds.skielazrak.Repositories.MoniteurRepository;

import java.util.List;

@Service
public class MoniteurService implements IMoniteurService{
    @Autowired
    MoniteurRepository moniteurRepository;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public void removeMoniteur(Long numMoniteur) {
        moniteurRepository.deleteById(numMoniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur).orElse(null);
    }
    @Override
    public Moniteur updateMoniteur(Moniteur moniteur){
        return moniteurRepository.save(moniteur);
    }
}
