package ism.ges_cours_planification_ism2023.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "periode")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Periode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true)
    private String libelle;
    //Attributs navigationnels
    @OneToMany(mappedBy = "periode",fetch = FetchType.LAZY)
    private List<Cours> cours;

}
