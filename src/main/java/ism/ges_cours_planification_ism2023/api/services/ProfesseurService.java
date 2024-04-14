package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.ProfesseurDto;
import ism.ges_cours_planification_ism2023.entities.Professeur;


import java.util.List;

public interface ProfesseurService {
    /* méthode pour récupérer la liste des professeurs dans la base de données*/
    public List<ProfesseurDto> getProfesseur();

    /* méthode pour ajouter des professeurs dans la base de données*/
    Professeur addProfesseur(ProfesseurDto professeurDto);
}
