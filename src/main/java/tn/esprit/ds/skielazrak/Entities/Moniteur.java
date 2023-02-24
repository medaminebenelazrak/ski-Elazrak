package tn.esprit.ds.skielazrak.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Moniteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numMoniteur;
    private String nomM;
    private String prenomM;
    private LocalDate dateRecru;
    @OneToMany()
    private List<Cours> cours;
}
