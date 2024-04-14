package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.SesssionCoursDto;
import ism.ges_cours_planification_ism2023.entities.EtatSessionCours;
import ism.ges_cours_planification_ism2023.entities.SessionCours;

import java.util.List;

public interface SessionCoursService {

    List<SesssionCoursDto> getSessionCours();
    SessionCours addSessionCours(SesssionCoursDto sesssionCoursDto);
    List<SesssionCoursDto> getSessionCoursFaits(EtatSessionCours etatSessionCours);

    List<SesssionCoursDto> getSessionCoursProfesseur(Long profId);
    void  annulerSessionCours(Long id);

}
