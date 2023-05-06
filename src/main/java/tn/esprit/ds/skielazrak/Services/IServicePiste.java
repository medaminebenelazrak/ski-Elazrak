package tn.esprit.ds.skielazrak.Services;

import tn.esprit.ds.skielazrak.Entities.Piste;

import java.util.List;

public interface IServicePiste {
    public Piste add (Piste piste);
    public Piste update (Piste piste);
    public Piste findOne (Long idPiste);
    public List<Piste> findAll ();
    public void delete (Long idPiste);
}
