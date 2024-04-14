package ism.ges_cours_planification_ism2023.api.controller;


import ism.ges_cours_planification_ism2023.api.dto.SallesCoursDto;
import ism.ges_cours_planification_ism2023.api.services.SallesCoursService;
import ism.ges_cours_planification_ism2023.entities.SallesDeCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salles")
//@CrossOrigin("http://localhost:4200")
public class SallesCoursRestController {

    @Autowired
    private SallesCoursService sallesCoursService;

    @GetMapping("liste-salles")
    @ResponseBody
    public ResponseEntity<List<SallesCoursDto>> getSalles(){
        List<SallesCoursDto> sallesCours=sallesCoursService.getSallesCours();
        return new ResponseEntity<>(sallesCours, HttpStatus.OK);//200
    }

    @PostMapping("add-salles")
    @ResponseBody
    public ResponseEntity<SallesCoursDto> addClasse(@RequestBody SallesCoursDto sallesCoursDto){
        SallesDeCours sallesDeCours=sallesCoursService.addSallesCours(sallesCoursDto);
        SallesCoursDto sallesCoursDto1=new SallesCoursDto(sallesDeCours);
        return ResponseEntity.status(HttpStatus.CREATED).body(sallesCoursDto1);//201
    }


}
