package ism.ges_cours_planification_ism2023.api.dto;

import ism.ges_cours_planification_ism2023.entities.Semestre;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SemestreDto {
    private Long id;
    private  String libelle;

    public SemestreDto(Semestre semestre) {
        id=semestre.getId();
        libelle=semestre.getLibelle();;
    }

}
