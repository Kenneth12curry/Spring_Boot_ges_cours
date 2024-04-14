package ism.ges_cours_planification_ism2023.api.controller;


import ism.ges_cours_planification_ism2023.api.dto.ProfesseurDto;
import ism.ges_cours_planification_ism2023.api.services.ProfesseurService;
import ism.ges_cours_planification_ism2023.entities.Professeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professeur")
//@CrossOrigin("http://localhost:4200")
public class ProfesseurRestController {

    @Autowired
    private ProfesseurService professeurService;

    @GetMapping("liste-professeur")
    @ResponseBody
    //méthode pour récupérer la liste des classes de la base de données à partir de l'API
    public ResponseEntity<List<ProfesseurDto>> getProfesseur(){
        List<ProfesseurDto> professeurs=professeurService.getProfesseur();
        return new ResponseEntity<>(professeurs, HttpStatus.OK);//200
    }

    @PostMapping("add-professeur")
    @ResponseBody
    public ResponseEntity<ProfesseurDto> addProfesseur(@RequestBody ProfesseurDto professeur){
        Professeur professeur1 =professeurService.addProfesseur(professeur);
        ProfesseurDto professeurDto=new ProfesseurDto(professeur1);
        return ResponseEntity.status(HttpStatus.CREATED).body(professeurDto);//201
    }
}
