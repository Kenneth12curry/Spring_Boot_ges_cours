package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.AnneeScolaireDto;
import ism.ges_cours_planification_ism2023.entities.AnneeScolaire;

import java.util.List;

public interface AnneeScolaireService {
    List<AnneeScolaireDto> getAnneeScolaire();
    AnneeScolaire addAnneeScolaire(AnneeScolaireDto anneeScolaireDto);

}
