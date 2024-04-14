package ism.ges_cours_planification_ism2023.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table(name = "emargements")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Emargement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(nullable = true)
    private boolean present;

    //Attributs navigationnels;
    @ManyToOne
    @JoinColumn(name = "etudiant_id",nullable = true)
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "session_cours_id",nullable = true)
    private SessionCours sessionCours;

    public boolean getPresent(){
        return present;
    }


}
