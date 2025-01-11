package net.javaguides.gestion_residence.repository;

import net.javaguides.gestion_residence.entity.Chambre;
import net.javaguides.gestion_residence.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement> findByResidentId(Long residentId);
    List<Paiement> findAll();
}
