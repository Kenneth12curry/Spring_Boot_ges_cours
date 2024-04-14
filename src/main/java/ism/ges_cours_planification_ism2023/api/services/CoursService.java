package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.CoursDto;
import ism.ges_cours_planification_ism2023.entities.Cours;
import ism.ges_cours_planification_ism2023.entities.EtatCours;

import java.util.List;


public interface CoursService {
    public List<CoursDto> getCours();
    Cours addCours(CoursDto coursDto);
    List<CoursDto> findByCoursAndEtat(EtatCours etat);
    List<CoursDto> getCoursByProfesseur(Long profId);
    List<CoursDto> getCoursByProfesseurAndPeriode(Long profId, Long periodeId);
    List<CoursDto> getCoursByEtudiants(Long etudiantsId);


}
