package ism.ges_cours_planification_ism2023.api.controller;

import ism.ges_cours_planification_ism2023.api.dto.EtudiantsDto;
import ism.ges_cours_planification_ism2023.api.services.EtudiantsService;
import ism.ges_cours_planification_ism2023.services.InscriptionEtudiantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
//@CrossOrigin("http://localhost:4200")
public class EtudiantRestController {

    @Autowired
    private EtudiantsService etudiantsService;

    @Autowired
    private InscriptionEtudiantsService inscriptionEtudiantsService;

    @GetMapping("liste-etudiants")
    @ResponseBody
    public ResponseEntity<List<EtudiantsDto>> getEtudiants(){
        List<EtudiantsDto> etudiants=etudiantsService.getEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);//200
    }

    @GetMapping("liste-etudiants/{coursId}")
    @ResponseBody
    public ResponseEntity<List<EtudiantsDto>> getEtudiantsByCours(@PathVariable Long coursId){
        List<EtudiantsDto> etudiantsDtoList=etudiantsService.getEtudiantByCours(coursId);
        return new ResponseEntity<>(etudiantsDtoList, HttpStatus.OK);//200
    }

    @GetMapping("liste-etudiants-classes/{classesId}")
    @ResponseBody
    public ResponseEntity<List<EtudiantsDto>> getEtudiantsByClasses(@PathVariable Long classesId){
        List<EtudiantsDto> etudiantsDtoList=etudiantsService.getEtudiantByClasses(classesId);
        return new ResponseEntity<>(etudiantsDtoList, HttpStatus.OK);//200
    }

    @PostMapping("/import")
    @ResponseBody
    public ResponseEntity<String> importStudents(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            inscriptionEtudiantsService.importStudentsFromExcelFile(file);
            return ResponseEntity.ok("Import successful");
        } else {
            return ResponseEntity.badRequest().body("No file selected");
        }
    }



}
