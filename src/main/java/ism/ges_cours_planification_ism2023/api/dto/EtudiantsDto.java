package ism.ges_cours_planification_ism2023.api.dto;

import ism.ges_cours_planification_ism2023.entities.Etudiant;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantsDto {

    private Long id;
    private String  nom;
    private String prenom;
    private String matricule;
    private String tuteur;
    private String  username;
    private String  password;
    private List<String> roles;

    public EtudiantsDto(Etudiant etudiant) {
        id= etudiant.getId();
        nom= etudiant.getNom();
        prenom=etudiant.getPrenom();
        matricule=etudiant.getMatricule();
        tuteur=etudiant.getTuteur();
        username=etudiant.getUsername();
        password=(etudiant.getPassword());
        roles=etudiant.getRoles()
                .stream()
                .map(role->role.getRoleName())
                .collect(Collectors.toList());
    }

}
