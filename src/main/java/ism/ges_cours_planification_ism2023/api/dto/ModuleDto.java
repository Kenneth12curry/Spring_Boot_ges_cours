package ism.ges_cours_planification_ism2023.api.dto;


import ism.ges_cours_planification_ism2023.entities.Module;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDto {
    private Long id;
    private String libelle;

    public ModuleDto(Module module) {
        id= module.getId();
        libelle= module.getLibelle();
    }
}
