package ism.ges_cours_planification_ism2023.api.dto;


import ism.ges_cours_planification_ism2023.entities.AnneeScolaire;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnneeScolaireDto {

    private Long id;
    private  String libelle;

    public AnneeScolaireDto(AnneeScolaire anneeScolaire) {
         id=anneeScolaire.getId();
         libelle=anneeScolaire.getLibelle();
    }
}
