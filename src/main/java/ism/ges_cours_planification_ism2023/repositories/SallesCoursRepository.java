package ism.ges_cours_planification_ism2023.repositories;

import ism.ges_cours_planification_ism2023.entities.SallesDeCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SallesCoursRepository extends JpaRepository<SallesDeCours,Long> {
}
