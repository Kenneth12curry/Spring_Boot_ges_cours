package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.SemestreDto;
import ism.ges_cours_planification_ism2023.entities.Semestre;
import ism.ges_cours_planification_ism2023.repositories.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SemestreServiceImpl implements SemestreService{

    @Autowired
    private SemestreRepository semestreRepository;
    @Override
    public List<SemestreDto> getSemestre() {
        return semestreRepository.findAll()
                .stream()
                .map(semestre->new SemestreDto(semestre))
                .collect(Collectors.toList());
    }

    @Override
    public Semestre addSemestre(SemestreDto semestreDto) {
        Semestre semestre=new Semestre();
        semestre.setLibelle(semestreDto.getLibelle());
        return semestreRepository.save(semestre);
    }

}
