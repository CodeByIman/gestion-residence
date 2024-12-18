package net.javaguides.gestion_residence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.gestion_residence.entity.Residence;

public interface ResidenceRepository extends JpaRepository<Residence, Long> {
    // Ajoutez des méthodes personnalisées ici si nécessaire
}
