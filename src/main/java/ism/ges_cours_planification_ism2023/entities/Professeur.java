package ism.ges_cours_planification_ism2023.entities;

import ism.ges_cours_planification_ism2023.security.entities.AppUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "professeur")
@DiscriminatorValue(value = "Professeur")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Professeur extends AppUser {

    @Column(nullable = true)
    private String grade;

    @Column(nullable = true)
    private String specialite;

    @OneToMany(mappedBy = "professeur",fetch = FetchType.LAZY)
    private List<Cours> cours;

    @OneToMany(mappedBy = "professeur",fetch = FetchType.LAZY)
    private List<SessionCours> sessioncours;

    //Constructeur
    public Professeur(Long id, String nom, String prenom) {
        super(id, nom, prenom);
    }


    @Override
    public String toString() {
        return "Professeur{" +
                "grades=" + grade +
                ", specialites=" + specialite +
                ", cours=" + cours +
                ", sessioncours=" + sessioncours +
                ", id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
