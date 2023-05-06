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
public class Moniteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long numMon;
    public String nomM;
    public String prenomM;
    @Temporal(TemporalType.DATE)

    public Date dateRecru;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Cours> cours;


}
