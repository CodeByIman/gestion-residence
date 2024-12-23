
package net.javaguides.gestion_residence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;


@Entity
@Table(name = "incidents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeIncident;
    private String statut;
    private String dateCreation;

    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private Technicien technicien;

    @ManyToOne
    @JoinColumn(name = "resident_id")
    private Resident resident;
}