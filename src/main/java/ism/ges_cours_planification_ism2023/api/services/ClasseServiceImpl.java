package ism.ges_cours_planification_ism2023.api.services;

import ism.ges_cours_planification_ism2023.api.dto.ClasseDto;
import ism.ges_cours_planification_ism2023.entities.Classe;
import ism.ges_cours_planification_ism2023.repositories.ClasseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClasseServiceImpl implements ClasseService{

    @Autowired
    private ClasseRepository classeRepository;

    /* méthode pour récupérer la liste des classes de la base de données*/
    @Override
    public List<ClasseDto> getClasse() {
        return classeRepository.findAll()
                .stream()
                .map(classe -> new ClasseDto(classe))
                .collect(Collectors.toList());
    }

    @Override
    public Classe addClasse(ClasseDto classeDto) {
       Classe classe = new Classe();
       classe.setFiliere(classeDto.getFiliere());
       classe.setLibelle(classeDto.getLibelle());
       classe.setNiveau(classeDto.getNiveau());
       return classeRepository.save(classe);
    }

}
