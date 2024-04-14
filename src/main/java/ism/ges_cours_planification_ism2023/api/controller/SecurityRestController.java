package ism.ges_cours_planification_ism2023.api.controller;


import ism.ges_cours_planification_ism2023.api.dto.ModuleDto;
import ism.ges_cours_planification_ism2023.api.dto.UserConnectDto;
import ism.ges_cours_planification_ism2023.api.dto.UserDto;
import ism.ges_cours_planification_ism2023.api.exceptions.ResourceNotFoundException;
import ism.ges_cours_planification_ism2023.api.services.SecurityServiceRest;
import ism.ges_cours_planification_ism2023.security.Utilitaire;
import ism.ges_cours_planification_ism2023.security.entities.AppUser;
import ism.ges_cours_planification_ism2023.security.repositories.AppUserRepository;
import ism.ges_cours_planification_ism2023.security.services.SecurityService;
import ism.ges_cours_planification_ism2023.security.services.SecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/security")
//@CrossOrigin("http://localhost:4200")
public class SecurityRestController {

    @Autowired
    private SecurityServiceRest securityServiceRest;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*@PostMapping("/login")
    @ResponseBody
    public ResponseEntity<UserDto> connection(@RequestBody UserConnectDto userConnect){
       AppUser client=service.getUserByUsername(userConnect.login);
       UserDto userDto=new UserDto(client);
        if(client==null) throw new ResourceNotFoundException(
               "Login ou Mot de Passe Incorrect");
        return new ResponseEntity<>(userDto, HttpStatus.OK);//200;
        }
    }*/

    @PostMapping("login")
    @ResponseBody
    public ResponseEntity<UserDto> connection(@RequestBody UserConnectDto userConnectDto) {
        try {
            // retourne l'utilisateur qui à ce login
            AppUser appUser = securityServiceRest.getUserByLogin(userConnectDto.getLogin());
            if (appUser != null && passwordEncoder.matches(userConnectDto.getPassword(), appUser.getPassword())) {
                //Conversion de l'objet de type appUser en un objet de type userDto
                UserDto userDto = new UserDto(appUser);
                return ResponseEntity.ok(userDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }


}