package org.utb.vcp.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utb.vcp.model.entity.Rol;
import org.utb.vcp.model.ERole;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombreRol(ERole nombreRol);

    List<Rol> findAll();

    Rol findByIdRol(Long idRol);
}
