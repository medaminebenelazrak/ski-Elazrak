package tn.esprit.ds.skielazrak.Entities;

import javax.persistence.*;
import java.util.List;
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCours;
    private int niveau;
    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;
    @Enumerated(EnumType.ORDINAL)
    private Support support;
    private float prix;
    private int creneau;
    @OneToMany(mappedBy = "cour")
    private List<Inscription> inscriptions;

}
