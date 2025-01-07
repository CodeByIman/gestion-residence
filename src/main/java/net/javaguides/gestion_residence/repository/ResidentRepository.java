package net.javaguides.gestion_residence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.gestion_residence.entity.Resident;

import java.util.List;

public interface ResidentRepository extends JpaRepository<Resident, Long> {

    // Méthode pour trouver tous les résidents par l'ID de la chambre
    List<Resident> findByChambreId(Long id);
    Resident findByEmail(String email);
}
