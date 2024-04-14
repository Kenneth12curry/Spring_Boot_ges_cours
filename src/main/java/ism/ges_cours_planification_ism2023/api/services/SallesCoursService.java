package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.SallesCoursDto;
import ism.ges_cours_planification_ism2023.entities.SallesDeCours;


import java.util.List;

public interface SallesCoursService {
    List<SallesCoursDto> getSallesCours();
    SallesDeCours addSallesCours(SallesCoursDto sallesCoursDto);
}
