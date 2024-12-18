
package net.javaguides.gestion_residence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;


@Entity
@Table(name = "techniciens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Technicien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTechnicien;
    private String nomTechnicien;
    private String specialite;

    @OneToMany(mappedBy = "technicien", cascade = CascadeType.ALL)
    private List<Incident> incidents;
}
