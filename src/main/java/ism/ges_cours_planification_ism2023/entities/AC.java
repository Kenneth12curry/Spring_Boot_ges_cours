package ism.ges_cours_planification_ism2023.entities;

import ism.ges_cours_planification_ism2023.security.entities.AppUser;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "ac")
@DiscriminatorValue(value = "AC")
@Data
@AllArgsConstructor
@Setter
@Getter
public class AC extends AppUser {
}
