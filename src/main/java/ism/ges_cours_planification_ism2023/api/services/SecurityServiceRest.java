package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.ProfesseurDto;
import ism.ges_cours_planification_ism2023.security.entities.AppUser;


public interface SecurityServiceRest {
    AppUser getUserByLogin(String login);
    void addProfesseur(ProfesseurDto professeurDto);

}
