package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.ProfesseurDto;
import ism.ges_cours_planification_ism2023.entities.Professeur;
import ism.ges_cours_planification_ism2023.repositories.ProfesseurRepository;
import ism.ges_cours_planification_ism2023.security.entities.AppRole;
import ism.ges_cours_planification_ism2023.security.repositories.AppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

    @Autowired
    ProfesseurRepository professeurRepository;
    @Autowired
    AppRoleRepository appRoleRepository;

    @Override
    public List<ProfesseurDto> getProfesseur() {
        return professeurRepository.findAll()
                .stream()
                .map(professeur -> new ProfesseurDto(professeur))
                .collect(Collectors.toList());
    }



    @Override
    public Professeur addProfesseur(ProfesseurDto professeurDto) {
        Professeur pl = new Professeur();
        AppRole appRole=appRoleRepository.findByRoleName("Professeur");
        // Donner des états aux attributs
        pl.setNom(professeurDto.getNom());
        pl.setPrenom(professeurDto.getPrenom());
        pl.setUsername(professeurDto.getLogin());
        pl.setGrade(professeurDto.getGrade());
        pl.setSpecialite(professeurDto.getSpecialite());
        //pl.setPassword(professeurDto.getPassword());
        pl.getRoles().add(appRole);
        return professeurRepository.save(pl);

    }


}
