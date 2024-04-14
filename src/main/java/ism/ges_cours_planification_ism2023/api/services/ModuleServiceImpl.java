package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.ModuleDto;
import ism.ges_cours_planification_ism2023.entities.Module;
import ism.ges_cours_planification_ism2023.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuleServiceImpl implements ModuleService{
    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public List<ModuleDto> getModule() {
        return moduleRepository.findAll()
                .stream()
                .map(module->new ModuleDto(module))
                .collect(Collectors.toList());
    }

    @Override
    public Module addModule(ModuleDto moduleDto) {
        Module module=new Module();
        module.setLibelle(moduleDto.getLibelle());
        return moduleRepository.save(module);
    }

}
