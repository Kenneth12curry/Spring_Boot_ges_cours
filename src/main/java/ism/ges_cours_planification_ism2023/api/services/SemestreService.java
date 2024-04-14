package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.SemestreDto;
import ism.ges_cours_planification_ism2023.entities.Semestre;


import java.util.List;

public interface SemestreService {
    List<SemestreDto> getSemestre();
    Semestre addSemestre(SemestreDto semestreDto);

}
