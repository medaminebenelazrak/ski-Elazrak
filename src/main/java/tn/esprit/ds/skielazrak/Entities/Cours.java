package tn.esprit.ds.skielazrak.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long numCours;
    public int niveau;
    public float prix;
    public int creneau;
    @Enumerated(EnumType.STRING)

    public TypeCours typeCours;
    @Enumerated(EnumType.STRING)

    public Support support;
    @OneToMany (cascade = CascadeType.ALL,mappedBy = "cours")
    public Set<Inscription> inscriptions;
    @ManyToOne
    public Moniteur moniteur;
}
