package ism.ges_cours_planification_ism2023.repositories;

import ism.ges_cours_planification_ism2023.entities.Emargement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmargementRepository extends JpaRepository<Emargement, Long> {
    //Redéfinition
    List<Emargement> findAll();
    @Override
    Page<Emargement> findAll(Pageable pageable);
}
