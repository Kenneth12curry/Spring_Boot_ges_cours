package ism.ges_cours_planification_ism2023.api.dto;


import ism.ges_cours_planification_ism2023.entities.EtatLieu;
import ism.ges_cours_planification_ism2023.entities.EtatSessionCours;
import ism.ges_cours_planification_ism2023.entities.SessionCours;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SesssionCoursDto {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private Date date;
        private LocalTime heureDebut;
        private LocalTime heureFin;
        private int nbreHeure;
        private EtatSessionCours etat;
        private EtatLieu Lieu;
        private String salles;
        private String professeurName;

        //Attributs navigationnels
        private Long cours;
        private Long sallescours;
        private Long professeur;
        private Long module;

        /*private int coursNbreHeure;
        private String moduleLibelle;*/




    public SesssionCoursDto(SessionCours sesssionCours) {
        this.id=sesssionCours.getId();
        this.date=sesssionCours.getDate();
        this.heureDebut=sesssionCours.getHeureDebut();
        this.nbreHeure=sesssionCours.getNbreHeure();
        this.heureFin=sesssionCours.getHeureFin();
        this.etat=sesssionCours.getEtat();
        this.Lieu=sesssionCours.getLieu();
        this.cours=sesssionCours.getCours().getId();
        this.sallescours=sesssionCours.getSallescours().getId();
        this.professeur=sesssionCours.getProfesseur().getId();
        this.module=sesssionCours.getModule().getId();
        //
        if(this.Lieu==EtatLieu.Enligne){
            salles="pas de salles";
        }else{
            salles=sesssionCours.getSallescours().getNumero();
        }
        this.professeurName=sesssionCours.getProfesseur().getPrenom();

    }


}
