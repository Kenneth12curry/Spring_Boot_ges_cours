package ism.ges_cours_planification_ism2023.api.dto;


import ism.ges_cours_planification_ism2023.entities.Cours;
import ism.ges_cours_planification_ism2023.entities.EtatCours;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoursDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int nbreHeureGlobal;
    @Enumerated(value = EnumType.STRING)
    private EtatCours etat;

    //Attributs navigationnels
    private Long professeur;
    private Long module;
    private Long anneeScolaire;

    private String professeurName;
    private String moduleLibelle;
    private String anneeScolaireLibelle;

    public CoursDto(Cours cours) {
        this.id = cours.getId();
        this.nbreHeureGlobal = cours.getNbreHeureGlobal();
        this.etat = cours.getEtat();
        this.professeurName = cours.getProfesseur().getPrenom()+' '+cours.getProfesseur().getNom();
        this.moduleLibelle = cours.getModule().getLibelle();
        this.anneeScolaireLibelle=cours.getAnneeScolaire().getLibelle();
        this.professeur= cours.getProfesseur().getId();
        this.module= cours.getModule().getId();
        this.anneeScolaire=cours.getAnneeScolaire().getId();

    }


}
