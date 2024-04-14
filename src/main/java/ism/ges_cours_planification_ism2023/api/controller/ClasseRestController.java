package ism.ges_cours_planification_ism2023.api.controller;

import ism.ges_cours_planification_ism2023.api.dto.ClasseDto;
import ism.ges_cours_planification_ism2023.api.services.ClasseService;
import ism.ges_cours_planification_ism2023.entities.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/classe")
//@CrossOrigin("http://localhost:4200")
//Request http/:localhost:8080/api/classe
public class ClasseRestController {

    //Request GET  http/:localhost:8080/api/classe
    //Request POST  http/:localhost:8080/api/classe
    //uri => api/classe
    /* @Autowired
    ClasseRepository classeRepository;*/
    @Autowired
    private ClasseService classeService;

    @GetMapping("liste-classe")
    @ResponseBody
    //méthode pour récupérer la liste des classes de la base de données à partir de l'API
    public ResponseEntity<List<ClasseDto>> getClasse(){
        List<ClasseDto> classes=classeService.getClasse();
        return new ResponseEntity<>(classes, HttpStatus.OK);//200
    }

    @PostMapping("add-classe")
    @ResponseBody
    public ResponseEntity<ClasseDto> addClasse(@RequestBody ClasseDto classeDto){
        Classe classe=classeService.addClasse(classeDto);
        //Conversion de l'objet de type Classe en un objet de type ClasseDto
        ClasseDto classeDto1=new ClasseDto(classe);
        return ResponseEntity.status(HttpStatus.CREATED).body(classeDto1);//201
    }

}
