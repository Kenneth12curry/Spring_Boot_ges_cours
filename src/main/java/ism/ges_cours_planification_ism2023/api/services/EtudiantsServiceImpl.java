package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.EtudiantsDto;
import ism.ges_cours_planification_ism2023.entities.Etudiant;
import ism.ges_cours_planification_ism2023.repositories.EtudiantsRepository;
import ism.ges_cours_planification_ism2023.security.entities.AppRole;
import ism.ges_cours_planification_ism2023.security.repositories.AppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudiantsServiceImpl implements EtudiantsService{

    @Autowired
    private EtudiantsRepository etudiantsRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Override
    public List<EtudiantsDto> getEtudiants() {
        return etudiantsRepository.findAll()
                .stream()
                .map(etudiants -> new EtudiantsDto(etudiants))
                .collect(Collectors.toList());
    }

    @Override
    public List<EtudiantsDto> getEtudiantByCours(Long coursId) {
          return etudiantsRepository.getEtudiantsByCoursId(coursId)
                    .stream()
                    .map(etudiants -> new EtudiantsDto(etudiants))
                    .collect(Collectors.toList());
    }

    @Override
    public List<EtudiantsDto> getEtudiantByClasses(Long classesId) {
        return etudiantsRepository.getEtudiantsByClassesId(classesId)
                .stream()
                .map(etudiants -> new EtudiantsDto(etudiants))
                .collect(Collectors.toList());
    }

    @Override
    public Etudiant addEtudiant(EtudiantsDto etudiantsDto) {
        Etudiant etudiant=new Etudiant();
        AppRole appRole=appRoleRepository.findByRoleName("Etudiant");
        etudiant.setNom(etudiantsDto.getNom());
        etudiant.setPrenom(etudiantsDto.getPrenom());
        etudiant.setMatricule(etudiantsDto.getMatricule());
        etudiant.setPassword(etudiantsDto.getPassword());
        etudiant.getRoles().add(appRole);
        etudiant.setTuteur(etudiantsDto.getTuteur());
        return etudiantsRepository.save(etudiant);
    }


}
