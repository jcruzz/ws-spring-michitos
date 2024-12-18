package org.utb.vcp.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utb.vcp.model.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
