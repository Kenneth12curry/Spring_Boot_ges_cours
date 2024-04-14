package ism.ges_cours_planification_ism2023.api.dto;

import ism.ges_cours_planification_ism2023.security.entities.AppUser;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String  nom;
    private String  prenom;
    private String   login;
    private String   password;
    private List<String > roles;

    public UserDto(AppUser user) {
        id= user.getId();
        nom=user.getNom();
        prenom=user.getPrenom();
        login=user.getUsername();
        roles=user.getRoles()
                .stream()
                .map(role->role.getRoleName())
                .collect(Collectors.toList());
    }
}
