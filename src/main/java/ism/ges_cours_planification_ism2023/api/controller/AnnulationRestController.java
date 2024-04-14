package ism.ges_cours_planification_ism2023.api.controller;

import ism.ges_cours_planification_ism2023.api.dto.DemandeAnnulationDto;
import ism.ges_cours_planification_ism2023.api.services.AnnulationService;
import ism.ges_cours_planification_ism2023.entities.DemandeAnnulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demande")
//@CrossOrigin("http://localhost:4200")
public class AnnulationRestController {
    @Autowired
    private AnnulationService annulationService;

    @PostMapping("add-demande")
    @ResponseBody
    public ResponseEntity<DemandeAnnulationDto> addAnneeScolaire(@RequestBody DemandeAnnulationDto demandeAnnulationDto){
        DemandeAnnulation demandeAnnulation =annulationService.addDemande(demandeAnnulationDto);
        DemandeAnnulationDto demandeAnnulationDto1=new DemandeAnnulationDto(demandeAnnulation);
        return ResponseEntity.status(HttpStatus.CREATED).body(demandeAnnulationDto1);//201
    }
}
