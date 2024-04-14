package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.DemandeAnnulationDto;
import ism.ges_cours_planification_ism2023.entities.DemandeAnnulation;


public interface AnnulationService {

    DemandeAnnulation addDemande(DemandeAnnulationDto demandeAnnulationDto);
}
