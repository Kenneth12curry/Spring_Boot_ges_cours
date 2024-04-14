package ism.ges_cours_planification_ism2023.controllers;


import ism.ges_cours_planification_ism2023.entities.Absence;
import ism.ges_cours_planification_ism2023.entities.Etudiant;
import ism.ges_cours_planification_ism2023.repositories.AbsenceRepository;
import ism.ges_cours_planification_ism2023.repositories.EtudiantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AbsenceController {

    @Autowired
    AbsenceRepository absenceRepository;
    @Autowired
    EtudiantsRepository etudiantsRepository;
    @GetMapping("/liste-absences-etudiants")
    public String listerAbsences(Model model,
              @RequestParam(name= "id",defaultValue = "") Long etudiantsId,
              @RequestParam(name = "page",defaultValue = "0") int page,
              @RequestParam(name = "size",defaultValue = "3") int size)
    {
        Page<Absence> pageAbsences;
        Etudiant etudiant=etudiantsRepository.findById(etudiantsId).orElse(null);
        pageAbsences=absenceRepository.getByEtudiant(etudiant,PageRequest.of(page,size));
        model.addAttribute("listeAbsences",pageAbsences.getContent());
        //total des pages
        model.addAttribute("pages",new int [pageAbsences.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "absence";
    }


}
