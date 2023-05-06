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
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idPiste;
    public Long numPiste;
    public String nomPiste;
    @Enumerated(EnumType.STRING)
    public Couleur couleur;
    public int longueur;
    public int pente;
    @ManyToMany(mappedBy = "pistes")
    public Set<Skieur> skieurs;




}
