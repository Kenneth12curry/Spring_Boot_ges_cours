package ism.ges_cours_planification_ism2023.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "justification")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Justification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(nullable = true)
    private String motif;

    @Column(nullable = true)
    @Enumerated(value = EnumType.STRING)
    private EtatJustification etat;

    @OneToOne
    @JoinColumn(name = "absence_id",nullable = true)
    private Absence absence;



}
