package net.javaguides.gestion_residence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.gestion_residence.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Ajoutez des méthodes personnalisées ici si nécessaire
}

