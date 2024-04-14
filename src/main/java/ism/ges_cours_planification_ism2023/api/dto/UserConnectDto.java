package ism.ges_cours_planification_ism2023.api.dto;

import ism.ges_cours_planification_ism2023.security.entities.AppUser;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserConnectDto {

    private  Long id;
    private String login;
    private String password;

    public UserConnectDto(AppUser appUser) {
        this.id = appUser.getId();
        this.login = appUser.getUsername();
        this.password = appUser.getPassword();
    }
}
