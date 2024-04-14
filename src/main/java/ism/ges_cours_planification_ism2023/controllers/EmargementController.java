package ism.ges_cours_planification_ism2023.controllers;


import com.lowagie.text.DocumentException;
import ism.ges_cours_planification_ism2023.entities.Emargement;
import ism.ges_cours_planification_ism2023.entities.PdfGenerator;
import ism.ges_cours_planification_ism2023.repositories.EmargementRepository;
import ism.ges_cours_planification_ism2023.services.EmargementsService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class EmargementController {

    @Autowired
    private EmargementRepository emargementRepository;

    @Autowired
    private EmargementsService emargementsService;
    @GetMapping("/liste-emargements")
    public String listerEmargements(Model model,
             @RequestParam(name = "page",defaultValue = "0") int page,
             @RequestParam(name = "size",defaultValue = "5") int size)
    {

        //Appel de la méthode findAll qui se trouve dans sessioncoursRepository
        Page<Emargement> emargements=emargementRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("listeEmargements",emargements.getContent());
        //total des pages
        model.addAttribute("pages",new int [emargements.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "emargements";

    }

    /* Exporter la liste des émargements en format pdf */
    @GetMapping("/export-to-pdf")
    public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException
    {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=emargements" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);
        List<Emargement> listofEmargements = emargementsService.getEmargementList();
        PdfGenerator generator = new PdfGenerator();
        generator.generate(listofEmargements, response);
    }


}
