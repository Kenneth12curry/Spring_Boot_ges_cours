package ism.ges_cours_planification_ism2023.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;



import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Entity
@Table(name = "session_cours")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SessionCours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(columnDefinition = "TIME",nullable = false)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime heureDebut;


    @Column(columnDefinition = "TIME",nullable = false)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime heureFin;

    @Column(nullable = false)
    private int nbreHeure;

    @Column()
    @Enumerated(value = EnumType.STRING)
    private EtatSessionCours etat;

    @Column()
    @Enumerated(value = EnumType.STRING)
    private EtatLieu Lieu;


    //Attributs navigationnels
    @ManyToOne
    @JoinColumn(name = "cours_id",nullable = true)
    Cours cours;

    @ManyToOne
    @JoinColumn(name = "salles_cours_id",nullable = true)
    SallesDeCours sallescours;

    @ManyToOne
    @JoinColumn(name = "professeur_id",nullable = true)
    Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "module_id",nullable = true)
    Module module;

    @OneToOne(mappedBy = "sessionCours")
    DemandeAnnulation demandeAnnulation;

    @OneToOne(mappedBy = "sessionCours")
    Absence absence;

    @OneToMany(mappedBy = "sessionCours",fetch = FetchType.LAZY)
    private List<Emargement> emargements;

}
