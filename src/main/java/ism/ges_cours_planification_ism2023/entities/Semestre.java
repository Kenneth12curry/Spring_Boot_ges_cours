package ism.ges_cours_planification_ism2023.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "semestre")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false)
    private String libelle;

    @ManyToMany(mappedBy = "semestres",fetch = FetchType.LAZY)
    private List<Cours> cours ;

}
