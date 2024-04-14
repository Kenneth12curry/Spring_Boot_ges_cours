package ism.ges_cours_planification_ism2023.api.dto;


import ism.ges_cours_planification_ism2023.entities.Absence;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbsenceDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    String etudiant;

    String sessionCours;

    public AbsenceDto(Absence absence) {
        this.id= absence.getId();
        this.date=absence.getDate();
        this.etudiant=absence.getEtudiant().getPrenom();
        this.sessionCours=absence.getSessionCours().getModule().getLibelle();
    }
}
