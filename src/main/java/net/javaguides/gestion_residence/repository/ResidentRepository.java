package net.javaguides.gestion_residence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.gestion_residence.entity.Resident;

import java.util.List;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
    // Récupérer les résidents par chambre
}
