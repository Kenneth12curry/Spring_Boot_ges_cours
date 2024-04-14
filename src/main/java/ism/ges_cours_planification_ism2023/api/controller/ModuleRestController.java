package ism.ges_cours_planification_ism2023.api.controller;

import ism.ges_cours_planification_ism2023.api.dto.ModuleDto;
import ism.ges_cours_planification_ism2023.api.services.ModuleService;
import ism.ges_cours_planification_ism2023.entities.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/module")
//@CrossOrigin("http://localhost:4200")
public class ModuleRestController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping("liste-module")
    @ResponseBody
    //méthode pour récupérer la liste des classes de la base de données à partir de l'API
    public ResponseEntity<List<ModuleDto>> getModule(){
        List<ModuleDto> modules=moduleService.getModule();
        return new ResponseEntity<>(modules, HttpStatus.OK);//200
    }

    @PostMapping("add-module")
    @ResponseBody
    public ResponseEntity<ModuleDto> addClasse(@RequestBody ModuleDto moduleDto){
        Module module=moduleService.addModule(moduleDto);
        ModuleDto moduleDto1=new ModuleDto(module);
        return ResponseEntity.status(HttpStatus.CREATED).body(moduleDto1);//201
    }
}
