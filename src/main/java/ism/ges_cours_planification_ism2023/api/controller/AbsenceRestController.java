package ism.ges_cours_planification_ism2023.api.controller;

import ism.ges_cours_planification_ism2023.api.dto.AbsenceDto;
import ism.ges_cours_planification_ism2023.api.services.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/absence")
//@CrossOrigin("http://localhost:4200")
public class AbsenceRestController {

    @Autowired
    private AbsenceService absenceService;

    @GetMapping("liste-absence-etudiant/{etudiantsId}")
    @ResponseBody
    public ResponseEntity<List<AbsenceDto>> getAbsence(@PathVariable Long etudiantsId){
        List<AbsenceDto> absenceDto=absenceService.getAbsenceEtudiant(etudiantsId);
        return new ResponseEntity<>(absenceDto, HttpStatus.OK);//200

    }

}
