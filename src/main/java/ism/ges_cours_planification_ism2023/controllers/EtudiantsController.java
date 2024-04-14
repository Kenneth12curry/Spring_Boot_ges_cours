package ism.ges_cours_planification_ism2023.controllers;


import ism.ges_cours_planification_ism2023.entities.Etudiant;
import ism.ges_cours_planification_ism2023.repositories.EtudiantsRepository;
import ism.ges_cours_planification_ism2023.services.InscriptionEtudiantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Controller
public class EtudiantsController {

    @Autowired
    EtudiantsRepository etudiantsRepository;

    @Autowired
    InscriptionEtudiantsService inscriptionEtudiantsService;

    @GetMapping("/liste-etudiants")
    public String listerEtudiants(Model model,
          @RequestParam(name = "page",defaultValue = "0") int page,
          @RequestParam(name = "size",defaultValue = "3") int size)
    {
        Page<Etudiant> pageEtudiants;
        //Appel de la méthode findAll qui se trouve dans sessioncoursRepository
        pageEtudiants=etudiantsRepository.findAll(PageRequest.of(page,size));


        model.addAttribute("listeEtudiants",pageEtudiants.getContent());
        //total des pages
        model.addAttribute("pages",new int [pageEtudiants.getTotalPages()]);
        model.addAttribute("currentPage",page);

        return "lister_etudiants";
    }


    @PostMapping("/students/import")
    public String importStudents(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                inscriptionEtudiantsService.importStudentsFromExcelFile(file);
                //return ResponseEntity.ok("Import successful");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/liste-etudiants";
    }




}
