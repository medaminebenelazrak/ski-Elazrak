package tn.esprit.ds.skielazrak.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numInscription;
    private int numSemaine;
    @ManyToOne
    private Cours cour;
    @ManyToOne()
    @JsonIgnore
    private Skieur skieur;
}
