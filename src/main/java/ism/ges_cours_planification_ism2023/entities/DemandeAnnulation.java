package ism.ges_cours_planification_ism2023.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "demande_annulation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DemandeAnnulation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true)
    private String motif;


    //Attributs navigationnels
    @OneToOne
    @JoinColumn(name = "session_cours_id",nullable = true)
    private SessionCours sessionCours;

}
