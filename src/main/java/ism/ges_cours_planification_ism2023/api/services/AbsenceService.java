package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.AbsenceDto;


import java.util.List;

public interface AbsenceService {
    List<AbsenceDto> getAbsenceEtudiant(Long etudiantId);
}
