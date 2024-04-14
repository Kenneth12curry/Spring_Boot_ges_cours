package ism.ges_cours_planification_ism2023.repositories;

import ism.ges_cours_planification_ism2023.entities.Cours;
import ism.ges_cours_planification_ism2023.entities.EtatCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long> {
    List<Cours> getByEtat(EtatCours etat);

    @Query("SELECT c from Cours c JOIN c.professeur p WHERE p.id = :profId")
    List<Cours> getByProfesseurId(@Param("profId") Long profId);

    @Query("SELECT c FROM Cours c JOIN c.professeur p JOIN c.periode pe WHERE p.id = :profId AND pe.id = :periodeId")
    List<Cours> getByProfesseurAndPeriodeId(@Param("profId") Long profId, @Param("periodeId") Long periodeId);

    @Query("SELECT c FROM Cours c JOIN c.etudiants e WHERE e.id = :etudiantsId")
    List<Cours> getCoursByEtudiantsId(@Param("etudiantsId") Long etudiantsId);



}
