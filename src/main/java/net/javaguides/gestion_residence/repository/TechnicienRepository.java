package net.javaguides.gestion_residence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.gestion_residence.entity.Technicien;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
    Technicien findByEmailAndPassword(String email, String password);
    // Ajoutez des méthodes personnalisées ici si nécessaire
}
