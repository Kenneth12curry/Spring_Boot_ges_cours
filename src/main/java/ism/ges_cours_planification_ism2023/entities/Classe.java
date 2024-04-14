package ism.ges_cours_planification_ism2023.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "classe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false)
    private String libelle;
    @Column(nullable = false)
    private String filiere;
    @Column(nullable = false)
    private String niveau;

    //Attributs navigationnels
    @ManyToMany(mappedBy = "classes",fetch = FetchType.LAZY)
    private List<Cours> cours;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(name = "classe_etudiant",
            joinColumns = @JoinColumn(name = "classe_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id"))
    private List<Etudiant> etudiants;

    public Classe(Long id) {
        this.id = id;
    }
}
