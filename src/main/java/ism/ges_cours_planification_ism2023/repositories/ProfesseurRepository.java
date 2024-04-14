package ism.ges_cours_planification_ism2023.repositories;

import ism.ges_cours_planification_ism2023.entities.Professeur;
import ism.ges_cours_planification_ism2023.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    Professeur findByNom(String nom);
    AppUser findByUsername(String username);

}
