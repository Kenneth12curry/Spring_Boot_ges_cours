package ism.ges_cours_planification_ism2023.api.controller;


import ism.ges_cours_planification_ism2023.api.dto.AnneeScolaireDto;
import ism.ges_cours_planification_ism2023.api.services.AnneeScolaireService;
import ism.ges_cours_planification_ism2023.entities.AnneeScolaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/annee")
//@CrossOrigin("http://localhost:4200")
public class AnneeScolaireRestController {
    @Autowired
    private AnneeScolaireService anneeScolaireService;

    @GetMapping("liste-annee")
    @ResponseBody
    public ResponseEntity<List<AnneeScolaireDto>> getClasse(){
        List<AnneeScolaireDto> annees=anneeScolaireService.getAnneeScolaire();
        return new ResponseEntity<>(annees, HttpStatus.OK);//200
    }

    @PostMapping("add-annee")
    @ResponseBody
    public ResponseEntity<AnneeScolaireDto> addAnneeScolaire(@RequestBody AnneeScolaireDto anneeScolaireDto){
        AnneeScolaire anneeScolaire1=anneeScolaireService.addAnneeScolaire(anneeScolaireDto);
        AnneeScolaireDto anneeScolaireDto1=new AnneeScolaireDto(anneeScolaire1);
        return ResponseEntity.status(HttpStatus.CREATED).body(anneeScolaireDto1);//201
    }

}
