package com.example.justhero.Repositories;

import com.example.justhero.Models.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long > {
}
