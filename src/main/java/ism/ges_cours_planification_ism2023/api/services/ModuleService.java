package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.ModuleDto;
import ism.ges_cours_planification_ism2023.entities.Module;


import java.util.List;

public interface ModuleService {

        List<ModuleDto> getModule();
        Module addModule(ModuleDto moduleDto);
}
