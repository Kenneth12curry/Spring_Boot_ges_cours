package ism.ges_cours_planification_ism2023.api.dto;


import ism.ges_cours_planification_ism2023.entities.Professeur;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfesseurDto {
    private Long id;
    private String  nom;
    private String prenom;
    private String  login;
    private String  password;
    private String grade;
    private String specialite;
    private List<String> roles;



    public ProfesseurDto(Professeur professeur) {
        id= professeur.getId();
        nom=professeur.getNom();
        prenom=professeur.getPrenom();
        login=professeur.getUsername();
        grade=professeur.getGrade();
        specialite=professeur.getSpecialite();
        roles=professeur.getRoles()
                .stream()
                .map(role->role.getRoleName())
                .collect(Collectors.toList());
    }

}
