package tn.esprit.ds.skielazrak.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long numAbon;

    public LocalDate dateDebut;


    public LocalDate dateFin;
    public float prixAbon;
    @Enumerated(EnumType.STRING)

    public TypeAbonnement typeAbon;
}
