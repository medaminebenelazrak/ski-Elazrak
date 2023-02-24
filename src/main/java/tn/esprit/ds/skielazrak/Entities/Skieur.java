package tn.esprit.ds.skielazrak.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;
    @ManyToMany(mappedBy = "skieurs")
    @JsonIgnore
    private List<Piste> pistes;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Abonnement abonnement;
    @OneToMany(mappedBy = "skieur")
    private List<Inscription> inscription;
}
