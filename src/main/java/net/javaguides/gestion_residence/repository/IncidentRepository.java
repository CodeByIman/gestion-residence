package net.javaguides.gestion_residence.repository;

import net.javaguides.gestion_residence.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    Incident save(Incident incident);

    List<Incident> findAll();

}
