package ism.ges_cours_planification_ism2023.security.services;

import ism.ges_cours_planification_ism2023.security.entities.AppRole;
import ism.ges_cours_planification_ism2023.security.entities.AppUser;

public interface SecurityService {

    AppUser getUserByUsername(String username);
    AppUser saveUser(String nom,String prenom,String username,String password);
    AppRole saveRole(String  roleName);
    void addRoleToUser(String username,String  roleName);
    void removeRoleToUser(String username,String  roleName);

    public AppUser connectedUser();

}
