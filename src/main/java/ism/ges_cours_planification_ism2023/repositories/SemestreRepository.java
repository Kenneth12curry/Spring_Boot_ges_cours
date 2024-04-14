package ism.ges_cours_planification_ism2023.repositories;


import ism.ges_cours_planification_ism2023.entities.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre,Long> {
}
