package ism.ges_cours_planification_ism2023.repositories;


import ism.ges_cours_planification_ism2023.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module,Long> {
    Module findByLibelle(String libelle);
}
