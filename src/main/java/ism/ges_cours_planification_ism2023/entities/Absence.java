package ism.ges_cours_planification_ism2023.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "absence")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "etudiant_id",nullable = true)
    Etudiant etudiant;

    @OneToOne
    @JoinColumn(name = "session_cours_id",nullable = true)
    SessionCours sessionCours;


    @OneToOne(mappedBy = "absence")
    Justification justification;

}
