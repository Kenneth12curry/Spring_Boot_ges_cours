package ism.ges_cours_planification_ism2023.repositories;

import ism.ges_cours_planification_ism2023.entities.EtatSessionCours;
import ism.ges_cours_planification_ism2023.entities.Module;
import ism.ges_cours_planification_ism2023.entities.Professeur;
import ism.ges_cours_planification_ism2023.entities.SessionCours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionCoursRepository extends JpaRepository<SessionCours,Long> {

    List<SessionCours> getByEtat(EtatSessionCours etatSessionCours);
    Page<SessionCours> getByEtat(EtatSessionCours etatSessionCours, Pageable pageable);
    Page<SessionCours> getByProfesseur(Professeur professeur, Pageable pageable);
    Page<SessionCours> getByModule(Module module, Pageable pageable);

    //sans la pagination
    @Query("SELECT c from SessionCours c JOIN c.professeur p WHERE p.id = :profId")
    List<SessionCours> getByProfesseurId(@Param("profId") Long profId);


}
