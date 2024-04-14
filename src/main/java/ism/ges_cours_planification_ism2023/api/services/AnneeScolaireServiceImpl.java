package ism.ges_cours_planification_ism2023.api.services;


import ism.ges_cours_planification_ism2023.api.dto.AnneeScolaireDto;
import ism.ges_cours_planification_ism2023.entities.AnneeScolaire;
import ism.ges_cours_planification_ism2023.repositories.AnneeScolaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnneeScolaireServiceImpl implements AnneeScolaireService{

    @Autowired
    private AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public List<AnneeScolaireDto> getAnneeScolaire() {
        return anneeScolaireRepository.findAll()
                .stream()
                .map(annee->new AnneeScolaireDto(annee))
                .collect(Collectors.toList());
    }

    @Override
    public AnneeScolaire addAnneeScolaire(AnneeScolaireDto anneeScolaireDto) {
        AnneeScolaire anneeScolaire=new AnneeScolaire();
        anneeScolaire.setLibelle(anneeScolaireDto.getLibelle());
        return anneeScolaireRepository.save(anneeScolaire);
    }


}
