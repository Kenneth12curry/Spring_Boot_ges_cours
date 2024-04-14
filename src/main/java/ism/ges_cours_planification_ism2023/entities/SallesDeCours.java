package ism.ges_cours_planification_ism2023.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "salles_cours")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SallesDeCours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column()
    private String nom;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private int  nbrePlaces;

    //Attributs navigationnels
    @OneToMany(mappedBy = "sallescours",fetch = FetchType.LAZY)
    private List<SessionCours> sessioncours;

}
