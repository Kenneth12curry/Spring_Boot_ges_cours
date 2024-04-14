package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.CoursDto;
import ism.ges_cours_planification_ism2023.entities.AnneeScolaire;
import ism.ges_cours_planification_ism2023.entities.Cours;
import ism.ges_cours_planification_ism2023.entities.EtatCours;
import ism.ges_cours_planification_ism2023.entities.Module;
import ism.ges_cours_planification_ism2023.entities.Professeur;
import ism.ges_cours_planification_ism2023.repositories.AnneeScolaireRepository;
import ism.ges_cours_planification_ism2023.repositories.CoursRepository;

import ism.ges_cours_planification_ism2023.repositories.ModuleRepository;
import ism.ges_cours_planification_ism2023.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursServiceImpl implements CoursService{

    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private ProfesseurRepository professeurRepository;
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public List<CoursDto> getCours() {
        return coursRepository.findAll()
                .stream()
                .map(cours -> new CoursDto(cours))
                .collect(Collectors.toList());
    }

    @Override
    public Cours addCours(CoursDto coursDto) {
        Module module=moduleRepository.findById(coursDto.getModule()).orElse(null);
        Professeur professeur=professeurRepository.findById(coursDto.getProfesseur()).orElse(null);
        AnneeScolaire anneeScolaire=anneeScolaireRepository.findById(coursDto.getAnneeScolaire()).orElse(null);

        Cours cours = new Cours();

        cours.setId(cours.getId());
        cours.setEtat(coursDto.getEtat());
        cours.setNbreHeureGlobal(coursDto.getNbreHeureGlobal());
        cours.setProfesseur(professeur);
        cours.setModule(module);
        cours.setAnneeScolaire(anneeScolaire);

        return coursRepository.save(cours);
    }

    @Override
    public List<CoursDto> findByCoursAndEtat(EtatCours etat) {
        List<Cours> coursList=coursRepository.getByEtat(etat);
        return coursList
                .stream()
                .map(cours->new CoursDto(cours))
                .collect(Collectors.toList());
    }

    @Override
    public List<CoursDto> getCoursByProfesseur(Long profId) {
        return coursRepository.getByProfesseurId(profId)
                .stream()
                .map(cours -> new CoursDto(cours))
                .collect(Collectors.toList());
    }

    @Override
    public List<CoursDto> getCoursByProfesseurAndPeriode(Long profId, Long periodeId) {
        return coursRepository.getByProfesseurAndPeriodeId(profId,periodeId)
                .stream()
                .map(cours -> new CoursDto(cours))
                .collect(Collectors.toList());
    }

    @Override
    public List<CoursDto> getCoursByEtudiants(Long etudiantsId) {
        return coursRepository.getCoursByEtudiantsId(etudiantsId)
                .stream()
                .map(cours -> new CoursDto(cours))
                .collect(Collectors.toList());
    }


}
