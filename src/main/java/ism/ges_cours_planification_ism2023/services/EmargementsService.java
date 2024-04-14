package ism.ges_cours_planification_ism2023.services;

import ism.ges_cours_planification_ism2023.entities.Emargement;


import java.util.List;

public interface EmargementsService {
        void addEmargements(Emargement emargement);
        List<Emargement> getEmargementList();

}
