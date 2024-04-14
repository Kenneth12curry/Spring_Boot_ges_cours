package ism.ges_cours_planification_ism2023.repositories;

import ism.ges_cours_planification_ism2023.entities.Absence;
import ism.ges_cours_planification_ism2023.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence,Long> {

    Page<Absence> getByEtudiant(Etudiant etudiant, Pageable pageable);

    @Query("SELECT a FROM Absence a WHERE a.etudiant.id = :etudiantId")
    List<Absence> getByAbsenceEtudiant(@Param("etudiantId")  Long etudiantId);

}
