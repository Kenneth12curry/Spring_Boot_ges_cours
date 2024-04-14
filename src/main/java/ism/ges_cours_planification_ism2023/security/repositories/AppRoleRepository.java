package ism.ges_cours_planification_ism2023.security.repositories;


import ism.ges_cours_planification_ism2023.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
  AppRole findByRoleName(String roleName);

}
