package ism.ges_cours_planification_ism2023.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "annee_scolaire")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AnneeScolaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column(nullable = false)
    private String libelle;
    @OneToMany(mappedBy = "anneeScolaire",fetch = FetchType.LAZY)
    private List<Cours> cours;

}
