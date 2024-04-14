package ism.ges_cours_planification_ism2023.api.dto;


import ism.ges_cours_planification_ism2023.entities.Classe;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.util.stream.Collectors;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClasseDto {


    private  Long id;
    private String libelle;
    private String filiere;
    private String niveau;

    public ClasseDto(Classe classe) {
        id= classe.getId();
        libelle= classe.getLibelle();
        filiere= classe.getFiliere();
        niveau= classe.getNiveau();
    }

}
