package ism.ges_cours_planification_ism2023.api.services;


import ism.ges_cours_planification_ism2023.api.dto.ProfesseurDto;
import ism.ges_cours_planification_ism2023.repositories.ProfesseurRepository;
import ism.ges_cours_planification_ism2023.security.entities.AppUser;
import ism.ges_cours_planification_ism2023.security.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceRestImpl implements SecurityServiceRest {
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    ProfesseurRepository professeurRepository;
    @Override
    public AppUser getUserByLogin(String login) {
          AppUser appUser =(AppUser) appUserRepository.findByUsername(login);
          return appUser;
    }

    @Override
    public void addProfesseur(ProfesseurDto professeurDto) {

    }

}
