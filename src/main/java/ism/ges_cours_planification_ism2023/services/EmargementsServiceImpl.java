package ism.ges_cours_planification_ism2023.services;

import ism.ges_cours_planification_ism2023.entities.Emargement;
import ism.ges_cours_planification_ism2023.repositories.EmargementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmargementsServiceImpl implements EmargementsService{

    @Autowired
    EmargementRepository emargementRepository;

    @Override
    public void addEmargements(Emargement emargement) {
        emargementRepository.save(emargement);
    }

    @Override
    public List<Emargement> getEmargementList() {
        return emargementRepository.findAll();
    }
}
