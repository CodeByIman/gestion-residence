package net.javaguides.gestion_residence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.gestion_residence.entity.Chambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    List<Chambre> findByStatus(Chambre.Status status);
    long countByStatus(Chambre.Status status);// Récupérer les chambres disponibles
}
