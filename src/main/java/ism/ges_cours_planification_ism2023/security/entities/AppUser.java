package ism.ges_cours_planification_ism2023.security.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role")
@DiscriminatorValue(value = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public  class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column(nullable = false)
    protected String nom;

    @Column(nullable = false)
    protected String prenom;

    @Column(nullable = true,unique = true)
    protected String username;

    @Column(nullable = true)
    protected String password;

    public AppUser(Long id) {
        this.id = id;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    List<AppRole> roles=new ArrayList<>();

    public AppUser(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
}
