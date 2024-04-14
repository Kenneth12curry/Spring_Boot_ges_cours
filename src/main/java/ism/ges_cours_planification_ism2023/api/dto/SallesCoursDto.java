package ism.ges_cours_planification_ism2023.api.dto;

import ism.ges_cours_planification_ism2023.entities.SallesDeCours;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SallesCoursDto {

    private Long id;
    private String nom;
    private String numero;
    private int  nbrePlaces;

    public SallesCoursDto(SallesDeCours sallesDeCours) {
       id= sallesDeCours.getId();
       nom= sallesDeCours.getNom();
       numero=sallesDeCours.getNumero();
       nbrePlaces=sallesDeCours.getNbrePlaces();
    }

}
