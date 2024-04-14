package ism.ges_cours_planification_ism2023.entities;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "cours")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false)
    private int nbreHeureGlobal;

    @Column()
    @Enumerated(value = EnumType.STRING)
    private EtatCours etat;


    //Attributs navigationnels
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "cours_semestre",
            joinColumns = @JoinColumn(name = "cours_id"),
            inverseJoinColumns = @JoinColumn(name = "semestre_id"))
    private List<Semestre> semestres;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "cours_classe",
            joinColumns = @JoinColumn(name = "cours_id"),
            inverseJoinColumns = @JoinColumn(name = "classe_id"))
    private List<Classe> classes;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(name = "cours_etudiant",
            joinColumns = @JoinColumn(name = "cours_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id"))
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "cours",fetch = FetchType.LAZY)
    private List<SessionCours> sessioncours;

    @ManyToOne
    @JoinColumn(name = "module_id",nullable = true)
    Module module;

    @ManyToOne
    @JoinColumn(name = "professeur_id",nullable = true)
    Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "annee_scolaire_id",nullable = true)
    AnneeScolaire anneeScolaire;

    @ManyToOne
    @JoinColumn(name ="periode_id",nullable = true)
    Periode periode;


}
