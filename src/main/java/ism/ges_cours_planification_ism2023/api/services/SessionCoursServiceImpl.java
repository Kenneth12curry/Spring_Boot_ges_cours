package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.SesssionCoursDto;
import ism.ges_cours_planification_ism2023.entities.*;
import ism.ges_cours_planification_ism2023.entities.Module;
import ism.ges_cours_planification_ism2023.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessionCoursServiceImpl implements SessionCoursService{

    @Autowired
    private SessionCoursRepository sessionCoursRepository;
    @Autowired
    SallesCoursRepository sallesCoursRepository;
    @Autowired
    CoursRepository coursRepository;
    @Autowired
    ProfesseurRepository professeurRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Override
    public List<SesssionCoursDto> getSessionCours() {
        return sessionCoursRepository.findAll()
                .stream()
                .map(sessionCours -> new SesssionCoursDto(sessionCours))
                .collect(Collectors.toList());
    }

    @Override
    public SessionCours addSessionCours(SesssionCoursDto sesssionCoursDto) {
        Cours cours=coursRepository.findById(sesssionCoursDto.getCours()).orElse(null);
        SallesDeCours sallesDeCours=sallesCoursRepository.findById(sesssionCoursDto.getSallescours()).orElse(null);
        Professeur professeur=professeurRepository.findById(sesssionCoursDto.getProfesseur()).orElse(null);
        Module module=moduleRepository.findById(sesssionCoursDto.getModule()).orElse(null);

        SessionCours sessionCours = new SessionCours();

        sessionCours.setDate(sesssionCoursDto.getDate());
        sessionCours.setEtat(sesssionCoursDto.getEtat());
        sessionCours.setLieu(sesssionCoursDto.getLieu());
        sessionCours.setNbreHeure(sesssionCoursDto.getNbreHeure());
        sessionCours.setHeureDebut(sesssionCoursDto.getHeureDebut());
        sessionCours.setHeureFin(sesssionCoursDto.getHeureFin());

        sessionCours.setSallescours(sallesDeCours);
        sessionCours.setCours(cours);
        sessionCours.setProfesseur(professeur);
        sessionCours.setModule(module);

        return sessionCoursRepository.save(sessionCours);
    }

    @Override
    public List<SesssionCoursDto> getSessionCoursFaits(EtatSessionCours etatSessionCours) {
        List<SessionCours> sessionCoursList=sessionCoursRepository.getByEtat(etatSessionCours);
        return sessionCoursList
                .stream()
                .map(sc->new SesssionCoursDto(sc))
                .collect(Collectors.toList());
    }

    @Override
    public List<SesssionCoursDto> getSessionCoursProfesseur(Long profId) {
        return sessionCoursRepository.getByProfesseurId(profId)
                .stream()
                .map(sc -> new SesssionCoursDto(sc))
                .collect(Collectors.toList());
    }

    @Override
    public void annulerSessionCours(Long id) {
        Optional<SessionCours> sessionCours=sessionCoursRepository.findById(id);
        SessionCours sessionCours1=sessionCours.get();
        sessionCours1.setEtat(EtatSessionCours.Annuler);
        sessionCoursRepository.save(sessionCours1);
    }

}
