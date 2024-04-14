package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.DemandeAnnulationDto;
import ism.ges_cours_planification_ism2023.entities.DemandeAnnulation;
import ism.ges_cours_planification_ism2023.repositories.DemandeAnnulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnulationServiceImpl implements AnnulationService {

    @Autowired
    private DemandeAnnulationRepository demandeAnnulationRepository;
    @Override
    public DemandeAnnulation addDemande(DemandeAnnulationDto demandeAnnulationDto) {
        DemandeAnnulation annulation=new DemandeAnnulation();
        annulation.setMotif(demandeAnnulationDto.getMotif());
        annulation.setSessionCours(demandeAnnulationDto.getSessionCours());
        return demandeAnnulationRepository.save(annulation);
    }
}
