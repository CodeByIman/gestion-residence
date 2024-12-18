package net.javaguides.gestion_residence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.gestion_residence.entity.Technicien;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
    // Ajoutez des méthodes personnalisées ici si nécessaire
}
