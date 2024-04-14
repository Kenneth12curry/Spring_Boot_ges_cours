package ism.ges_cours_planification_ism2023.controllers;


import ism.ges_cours_planification_ism2023.entities.Absence;
import ism.ges_cours_planification_ism2023.entities.EtatJustification;
import ism.ges_cours_planification_ism2023.entities.Justification;
import ism.ges_cours_planification_ism2023.repositories.AbsenceRepository;
import ism.ges_cours_planification_ism2023.repositories.JustificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JustificationController {

    @Autowired
    JustificationRepository justificationRepository;
    @Autowired
    AbsenceRepository absenceRepository;

    @GetMapping("/justifications-absences")
    public String listerJustifications(Model model,
                 @RequestParam(name= "id",defaultValue = "") Long absenceId)
    {
        Justification justificationObjet;
        Absence absence=absenceRepository.findById(absenceId).orElse(null);
        justificationObjet=justificationRepository.getByAbsence(absenceId);
        model.addAttribute("Justification",justificationObjet);
        return "pagejustification";
    }

    @GetMapping("/justification-acceptée")
    public String JustificationAcceptée(Model model,
                  @RequestParam(name="id",defaultValue = "") Long idJustification)
    {
        Justification justification=justificationRepository.findById(idJustification).orElse(null);
        justification.setEtat(EtatJustification.Acceptée);
        justificationRepository.save(justification);
        return "redirect:/liste-etudiants";
    }


    @GetMapping("/justification-refusée")
    public String JustificationRefusée(Model model,
                   @RequestParam(name="id",defaultValue = "") Long idJustification)
    {
        Justification justification=justificationRepository.findById(idJustification).orElse(null);
        justification.setEtat(EtatJustification.Refusée);
        justificationRepository.save(justification);
        return "redirect:/liste-etudiants";

    }


    @GetMapping("/traitement")
    public String lienClicked(Model model,@RequestParam(value = "click" ) Boolean clicked,
                              @RequestParam(name = "page",defaultValue = "0") int page,
                              @RequestParam(name = "size",defaultValue = "3") int size)
    {

        List<Justification> justificationPage = null;
        if (clicked) {
          justificationPage =justificationRepository.getByEtat(EtatJustification.Acceptée);
        }
        if(!clicked){
            justificationPage=justificationRepository.getByEtat(EtatJustification.Refusée);
        }
        
        //model.addAttribute("listeJustification",justificationPage.getContent());
        //total des pages
        //model.addAttribute("pages",new int [justificationPage.getTotalPages()]);
        model.addAttribute("listeJustification",justificationPage);
        
        return "liste_justification_traitement";
        
    }



}
