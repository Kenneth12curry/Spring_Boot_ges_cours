package ism.ges_cours_planification_ism2023.api.controller;

import ism.ges_cours_planification_ism2023.api.dto.SemestreDto;
import ism.ges_cours_planification_ism2023.api.services.SemestreService;
import ism.ges_cours_planification_ism2023.entities.Semestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/semestre")
//@CrossOrigin("http://localhost:4200")
public class SemestreRestController {
    @Autowired
    private SemestreService semestreService;

    @GetMapping("liste-semestre")
    @ResponseBody
    public ResponseEntity<List<SemestreDto>> getSemestre(){
        List<SemestreDto> semestres=semestreService.getSemestre();
        return new ResponseEntity<>(semestres, HttpStatus.OK);//200
    }

    @PostMapping("add-semestre")
    @ResponseBody
    public ResponseEntity<SemestreDto> addAnneeScolaire(@RequestBody SemestreDto semestreDto){
        Semestre semestre=semestreService.addSemestre(semestreDto);
        SemestreDto semestreDto1=new SemestreDto(semestre);
        return ResponseEntity.status(HttpStatus.CREATED).body(semestreDto1);//201
    }

}
