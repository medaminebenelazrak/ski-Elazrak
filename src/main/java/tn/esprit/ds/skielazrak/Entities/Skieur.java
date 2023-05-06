package tn.esprit.ds.skielazrak.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long numSkieur;
    public String nomS;
    private String prenomS;
    @Temporal(TemporalType.DATE)

    public Date dateNaissance;
    public String ville;
    @ManyToMany
    public Set<Piste> pistes;
@OneToMany(mappedBy = "skieur", cascade= CascadeType.REMOVE)
   private Set<Inscription> inscriptions;
@OneToOne
    private Abonnement abonnement;
}
