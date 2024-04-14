package ism.ges_cours_planification_ism2023.controllers;

import ism.ges_cours_planification_ism2023.entities.EtatSessionCours;
import ism.ges_cours_planification_ism2023.entities.Module;
import ism.ges_cours_planification_ism2023.entities.Professeur;
import ism.ges_cours_planification_ism2023.entities.SessionCours;
import ism.ges_cours_planification_ism2023.repositories.ModuleRepository;
import ism.ges_cours_planification_ism2023.repositories.ProfesseurRepository;
import ism.ges_cours_planification_ism2023.repositories.SessionCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class SessionCoursController {

    @Autowired
    private SessionCoursRepository sessionCoursRepository;
    @Autowired
    private ProfesseurRepository professeurRepository;
    @Autowired
    private ModuleRepository moduleRepository;


    @GetMapping("/liste-session-cours")
    public String listerSessionCours(Model model,
                 @RequestParam(name = "page",defaultValue = "0") int page,
                 @RequestParam(name = "size",defaultValue = "5") int size,
                 //recherche de la liste des sessions de cours en fonction du module
                 @RequestParam(name= "keyword",defaultValue = "") Long keyword,
                 //recherche de la liste des sessions de cours en fonction du professeur
                 @RequestParam(name= "keywordprofesseur",defaultValue = "") Long keywordprofesseur)
    {
        Page<SessionCours> pageSessionCours;
        EtatSessionCours etat= EtatSessionCours.Planifier;
        //Appel de la méthode findAll qui se trouve dans sessioncoursRepository
        pageSessionCours=sessionCoursRepository.getByEtat(etat,PageRequest.of(page,size));
        //model.addAttribute("listeSession",pageSessionCours.getContent());
        //total des pages
        // model.addAttribute("pages",new int [pageSessionCours.getTotalPages()]);
        // model.addAttribute("currentPage",page);


        if(keyword!=null){
            //System.out.println("Hello world");
            Optional<Module> module=moduleRepository.findById(keyword);
            Module module1=module.get();
            pageSessionCours=sessionCoursRepository.getByModule(module1,PageRequest.of(page,size));
            //model.addAttribute("keyword",keyword);

        }

        if(keywordprofesseur!=null){

            Optional<Professeur> professeur=professeurRepository.findById(keywordprofesseur);
            Professeur professeur1=professeur.get();
            pageSessionCours=sessionCoursRepository.getByProfesseur(professeur1,PageRequest.of(page,size));
            //model.addAttribute("keyword",keywordprofesseur);
        }


        model.addAttribute("listeSession",pageSessionCours.getContent());
        //total des pages
        model.addAttribute("pages",new int [pageSessionCours.getTotalPages()]);
        model.addAttribute("currentPage",page);

        //Chargement de la liste des professeurs au niveau de la vue
        List<Professeur> professeurList=professeurRepository.findAll();
        model.addAttribute("listeProfesseur",professeurList);

        //Chargement de la liste des  modules au niveau de la vue
        List<Module> moduleList=moduleRepository.findAll();
        model.addAttribute("listeModule",moduleList);

        return "liste_session_cours";
    }


    @GetMapping("/update-session-cours-valider")
    public String ValiderSessionCours(Model model,
            @RequestParam(name="id",defaultValue = "") Long idSessionCours)
    {
        Optional<SessionCours> Sc=sessionCoursRepository.findById(idSessionCours);
        SessionCours sc=Sc.get();
        sc.setEtat(EtatSessionCours.Valider);
        sessionCoursRepository.save(sc);
        return "redirect:/liste-session-cours";
    }


    @GetMapping("/update-session-cours-invalider")
    public String InvaliderSessionCours(Model model,
           @RequestParam(name="id",defaultValue = "") Long idSessionCours)
    {
        Optional<SessionCours> Sc=sessionCoursRepository.findById(idSessionCours);
        SessionCours sc=Sc.get();
        sc.setEtat(EtatSessionCours.Invalider);
        sessionCoursRepository.save(sc);
        return "redirect:/liste-session-cours";
    }


    @PostMapping("/lister-session-cours-valider")
    public String listerSessionCoursValider(Model model,
                @RequestParam(name = "page",defaultValue = "0") int page,
                @RequestParam(name = "size",defaultValue = "5") int size,
                /* récupération du name du bouton dans cette variable*/@RequestParam String Button)
    {

        Page<SessionCours> pageSessionCours=null;

        if (Button.equals("valider")){
            EtatSessionCours etat= EtatSessionCours.Valider;
            pageSessionCours=sessionCoursRepository.getByEtat(etat,PageRequest.of(page,size));
        }

        if(Button.equals("invalider")){
            EtatSessionCours etat= EtatSessionCours.Invalider;
            pageSessionCours=sessionCoursRepository.getByEtat(etat,PageRequest.of(page,size));
        }

        //Chargement des données dans la vue
        model.addAttribute("listeSession",pageSessionCours.getContent());
        //total des pages
        model.addAttribute("pages",new int [pageSessionCours.getTotalPages()]);
        model.addAttribute("currentPage",page);

        //Chargement de la liste des professeurs au niveau de la vue
        List<Professeur> professeurList=professeurRepository.findAll();
        model.addAttribute("listeProfesseur",professeurList);

        //Chargement de la liste des  modules au niveau de la vue
        List<Module> moduleList=moduleRepository.findAll();
        model.addAttribute("listeModule",moduleList);

        return "liste_session_cours";

    }


}
