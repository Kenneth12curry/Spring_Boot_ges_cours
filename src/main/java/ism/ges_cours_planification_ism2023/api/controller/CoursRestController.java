package ism.ges_cours_planification_ism2023.api.controller;


import ism.ges_cours_planification_ism2023.api.dto.CoursDto;
import ism.ges_cours_planification_ism2023.api.services.CoursService;
import ism.ges_cours_planification_ism2023.entities.Cours;
import ism.ges_cours_planification_ism2023.entities.EtatCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cours")
//@CrossOrigin("http://localhost:4200")
public class CoursRestController {

    @Autowired
    private CoursService coursService;

    @GetMapping("liste-cours")
    @ResponseBody
    public ResponseEntity<List<CoursDto>> getCours(){
        List<CoursDto> cours=coursService.getCours();
        return new ResponseEntity<>(cours, HttpStatus.OK);//200
    }

    @PostMapping("add-cours")
    @ResponseBody
    public ResponseEntity<CoursDto> addClasse(@RequestBody CoursDto coursDto){
        Cours cours =coursService.addCours(coursDto);
        CoursDto coursDto1=new CoursDto(cours);
        return ResponseEntity.status(HttpStatus.CREATED).body(coursDto1);//201
    }

    @GetMapping("liste-cours-etat/{valeur}")
    @ResponseBody
    public ResponseEntity<List<CoursDto>> getCoursEtat(@PathVariable String valeur){
        EtatCours etat=EtatCours.convertStringToEtatCours(valeur);
        List<CoursDto> cours;
        if(etat!=null){
            cours=coursService.findByCoursAndEtat(etat);
        }
        else{
            cours=coursService.getCours();
        }
        return new ResponseEntity<>(cours, HttpStatus.OK);//200
    }

    @GetMapping("liste-cours-prof/{profId}")
    @ResponseBody
    public ResponseEntity<List<CoursDto>> listerCoursUnProf(@PathVariable Long profId){
        List<CoursDto> cours=coursService.getCoursByProfesseur(profId);
        return new ResponseEntity<>(cours, HttpStatus.OK);//200//201
    }
    @GetMapping("liste-cours-prof-periode/{profId}/{periodeId}")
    @ResponseBody
    public ResponseEntity<List<CoursDto>> listerCoursUnProfAndPeriode(@PathVariable Long profId, @PathVariable Long periodeId){
        List<CoursDto> cours=coursService.getCoursByProfesseurAndPeriode(profId,periodeId);
        return new ResponseEntity<>(cours, HttpStatus.OK);//200//201
    }

    @GetMapping("liste-cours-etudiants/{etudiantsId}")
    @ResponseBody
    public ResponseEntity<List<CoursDto>> listerCoursUnProfAndPeriode(@PathVariable Long etudiantsId){
        List<CoursDto> cours=coursService.getCoursByEtudiants(etudiantsId);
        return new ResponseEntity<>(cours, HttpStatus.OK);//200//201
    }

}
