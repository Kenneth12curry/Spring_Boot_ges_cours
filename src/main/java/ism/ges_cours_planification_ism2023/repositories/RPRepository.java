package ism.ges_cours_planification_ism2023.repositories;


import ism.ges_cours_planification_ism2023.entities.RP;
import ism.ges_cours_planification_ism2023.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RPRepository extends JpaRepository<RP,Long> {
    AppUser findByUsername(String username);
}
