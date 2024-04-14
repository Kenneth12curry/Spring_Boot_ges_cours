package ism.ges_cours_planification_ism2023.security.services;


import ism.ges_cours_planification_ism2023.security.entities.AppRole;
import ism.ges_cours_planification_ism2023.security.entities.AppUser;
import ism.ges_cours_planification_ism2023.security.repositories.AppRoleRepository;
import ism.ges_cours_planification_ism2023.security.repositories.AppUserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class SecurityServiceImpl implements SecurityService, UserDetailsService {
    @Autowired
    AppRoleRepository appRoleRepository;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public SecurityServiceImpl(AppRoleRepository appRoleRepository, AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appRoleRepository = appRoleRepository;
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public AppUser saveUser(String nom,String prenom, String username, String password) {
         AppUser user=appUserRepository.findByUsername(username);
          if(user!=null) throw  new RuntimeException("Cet utilisateur existe deja ");
           user=new AppUser();
           user.setNom(nom);
           user.setPrenom(prenom);
           user.setPassword(passwordEncoder.encode(password));
           user.setUsername(username);
         return appUserRepository.save(user);
    }

    @Override
    public AppRole saveRole(String roleName) {
        AppRole role=new AppRole(null,roleName,null);
        return appRoleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
      AppUser user=appUserRepository.findByUsername(username);
      if(user==null) throw  new RuntimeException("Cet utilisateur n'existe pas ");
      AppRole role =appRoleRepository.findByRoleName(roleName);
      if(role==null) throw  new RuntimeException("Cet Role n'existe pas ");
        user.getRoles().add(role);
        appUserRepository.save(user);
    }

    @Override
    public void removeRoleToUser(String username, String roleName) {
        AppUser user=appUserRepository.findByUsername(username);
        if(user==null) throw  new RuntimeException("Cet utilisateur n'existe pas ");
        AppRole role =appRoleRepository.findByRoleName(roleName);
        if(role==null) throw  new RuntimeException("Cet Role n'existe pas ");
        user.getRoles().remove(role);
        appUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=getUserByUsername(username);
        //Appuser => User Herite UserDetails
        //AppRole => SimpleGrantedAuthority
        //List<{ nom :"Diop", age: 12}>.stream().map(p->p.getAge()).sum()
        return new User(
                appUser.getUsername(),
                appUser.getPassword(),
                appUser.getRoles()
                        .stream()
                        .map(role->new SimpleGrantedAuthority(role.getRoleName()))
                        .collect(Collectors.toList())
               );
    }

    @Override
    public AppUser connectedUser() {
        try {
            SecurityContext context = SecurityContextHolder.getContext();
            Authentication authentication = context.getAuthentication();
            String login = "";
            if (authentication.getPrincipal() instanceof UserDetails) {
                UserDetails user = (UserDetails) authentication.getPrincipal();
                login = user.getUsername();
            }
            if (authentication.getPrincipal() instanceof String)
                login = (String) authentication.getPrincipal();
            return appUserRepository
                    .findByLogin(login)
                    .orElse(null);
        } catch (Exception e) {
            throw e;
        }
    }
}
