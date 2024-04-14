package ism.ges_cours_planification_ism2023.repositories;

import ism.ges_cours_planification_ism2023.entities.EtatJustification;
import ism.ges_cours_planification_ism2023.entities.Justification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JustificationRepository extends JpaRepository<Justification,Long> {
    @Query("SELECT j FROM Justification j WHERE j.absence.id = :absenceId AND j.etat IS NULL")
    Justification getByAbsence(@Param("absenceId") Long absenceId);

    List<Justification> getByEtat(EtatJustification etat);


}
