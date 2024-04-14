package ism.ges_cours_planification_ism2023.api.controller;

import ism.ges_cours_planification_ism2023.api.dto.SesssionCoursDto;
import ism.ges_cours_planification_ism2023.api.services.SessionCoursService;
import ism.ges_cours_planification_ism2023.entities.EtatSessionCours;
import ism.ges_cours_planification_ism2023.entities.SessionCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/session-cours")
//@CrossOrigin("http://localhost:4200")
public class SessionCoursRestController {

    @Autowired
    private SessionCoursService sessionCoursService;

    @GetMapping("liste-session-cours")
    @ResponseBody
    public ResponseEntity<List<SesssionCoursDto>> getSessionCours(){
        List<SesssionCoursDto> session_cours=sessionCoursService.getSessionCours();
        return new ResponseEntity<>(session_cours, HttpStatus.OK);//200
    }

    @PostMapping("add-session-cours")
    @ResponseBody
    public ResponseEntity<SesssionCoursDto> addSessionCours(@RequestBody SesssionCoursDto sesssionCoursDto){
        SessionCours sessionCours=sessionCoursService.addSessionCours(sesssionCoursDto);
        SesssionCoursDto sesssionCoursDto1=new SesssionCoursDto(sessionCours);
        return ResponseEntity.status(HttpStatus.CREATED).body(sesssionCoursDto1);//201
    }

    @GetMapping("liste-session-cours-etat/{valeur}")
    @ResponseBody
    public ResponseEntity<List<SesssionCoursDto>> getCoursEtat(@PathVariable String valeur){
        EtatSessionCours etat= EtatSessionCours.convertStringToEtatCours(valeur);
        List<SesssionCoursDto> sessionCours;
        if(etat!=null){
            sessionCours=sessionCoursService.getSessionCoursFaits(etat);
        }
        else{
            sessionCours=sessionCoursService.getSessionCours();
        }
        return new ResponseEntity<>(sessionCours, HttpStatus.OK);//200
    }

    @GetMapping("liste-session-cours-prof/{profId}")
    @ResponseBody
    public ResponseEntity<List<SesssionCoursDto>> getSessionsCoursProf(@PathVariable Long profId){
        List<SesssionCoursDto> sessionCours;
        if(profId!=null){
            sessionCours=sessionCoursService.getSessionCoursProfesseur(profId);
        }
        else{
            sessionCours=sessionCoursService.getSessionCours();
        }
        return new ResponseEntity<>(sessionCours, HttpStatus.OK);//200
    }

    @GetMapping("annuler-session/{id}")
    @ResponseBody
    public void AnnulerSessionCours(@PathVariable Long id){
       sessionCoursService.annulerSessionCours(id);
    }


}
