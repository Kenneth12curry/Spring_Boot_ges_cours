package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.AbsenceDto;
import ism.ges_cours_planification_ism2023.repositories.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbsenceServiceImpl implements AbsenceService{

    @Autowired
    private AbsenceRepository absenceRepository;
    @Override
    public List<AbsenceDto> getAbsenceEtudiant(Long etudiantId) {
        return absenceRepository.getByAbsenceEtudiant(etudiantId)
                .stream()
                .map(absence -> new AbsenceDto(absence))
                .collect(Collectors.toList());
    }

}
