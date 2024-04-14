package ism.ges_cours_planification_ism2023.security.repositories;

import ism.ges_cours_planification_ism2023.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AppUserRepository  extends JpaRepository<AppUser,Long> {

    @Query("SELECT u FROM AppUser u WHERE u.username=:login")
    Optional<AppUser> findByLogin(@Param("login") String login);

    AppUser findByUsername(String username);

}
