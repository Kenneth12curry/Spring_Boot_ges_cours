package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.EtudiantsDto;
import ism.ges_cours_planification_ism2023.entities.Etudiant;

import java.util.List;

public interface EtudiantsService {

    List<EtudiantsDto> getEtudiants();
    List<EtudiantsDto> getEtudiantByCours(Long coursId);
    List<EtudiantsDto> getEtudiantByClasses(Long classesId);
     Etudiant addEtudiant(EtudiantsDto etudiantsDto);


}
