package ism.ges_cours_planification_ism2023.api.dto;


import ism.ges_cours_planification_ism2023.entities.DemandeAnnulation;
import ism.ges_cours_planification_ism2023.entities.SessionCours;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemandeAnnulationDto {
    private Long id;
    private String motif;
    private String sc;
    //Attributs navigationnels
    private SessionCours sessionCours;

    public DemandeAnnulationDto(DemandeAnnulation demandeAnnulation) {
        id=demandeAnnulation.getId();
        motif=demandeAnnulation.getMotif();
        //sc=sessionCours.getModule().getLibelle();
    }
}
