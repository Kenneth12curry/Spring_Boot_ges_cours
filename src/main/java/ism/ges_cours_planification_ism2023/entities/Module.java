package ism.ges_cours_planification_ism2023.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "module")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column(nullable = false)
    private String libelle;

    //Attributs navigationnels
    @OneToMany(mappedBy = "module",fetch = FetchType.LAZY)
    private List<Cours> cours;

    @OneToMany(mappedBy = "module",fetch = FetchType.LAZY)
    private List<SessionCours> sessioncours;

}
