package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.SallesCoursDto;
import ism.ges_cours_planification_ism2023.entities.SallesDeCours;
import ism.ges_cours_planification_ism2023.repositories.SallesCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SallesCoursServiceImpl implements SallesCoursService{

    @Autowired
    private SallesCoursRepository sallesCoursRepository;
    @Override
    public List<SallesCoursDto> getSallesCours() {
        return sallesCoursRepository.findAll()
                .stream()
                .map(sallesCours-> new SallesCoursDto(sallesCours))
                .collect(Collectors.toList());
    }

    @Override
    public SallesDeCours addSallesCours(SallesCoursDto sallesCoursDto) {
        SallesDeCours sallesDeCours = new SallesDeCours();
        sallesDeCours.setNom(sallesCoursDto.getNom());
        sallesDeCours.setNumero(sallesCoursDto.getNumero());
        sallesDeCours.setNbrePlaces(sallesCoursDto.getNbrePlaces());
        return sallesCoursRepository.save(sallesDeCours);
    }

}
