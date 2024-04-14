package ism.ges_cours_planification_ism2023.entities;

import ism.ges_cours_planification_ism2023.security.entities.AppUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "etudiant")
@DiscriminatorValue(value = "Etudiant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Etudiant extends AppUser {

    @Column()
    private String matricule;
    @Column()
    private String tuteur;

    //Attributs navigationnels
    //mappedBy se met dans la classe qui  ne reçoit pas de clé étrangère
    @ManyToMany(mappedBy = "etudiants",fetch = FetchType.LAZY)
    private List<Cours> cours;
    @OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY)
    private List<Absence> absences;

    @ManyToMany(mappedBy = "etudiants",fetch = FetchType.LAZY)
    private List<Classe> classes;

    @OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY)
    private List<Emargement> emargements;

}
