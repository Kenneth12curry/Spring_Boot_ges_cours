package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.ClasseDto;
import ism.ges_cours_planification_ism2023.entities.Classe;


import java.util.List;

public interface ClasseService {

    /* méthode pour récupérer la liste des classes dans la base de données*/
    public List<ClasseDto> getClasse();

    /* méthode pour ajouter des classes dans la base de données*/
    Classe addClasse(ClasseDto classeDto);

}
