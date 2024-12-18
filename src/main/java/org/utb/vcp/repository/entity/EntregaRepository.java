package org.utb.vcp.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utb.vcp.model.entity.Entrega;
import org.utb.vcp.model.entity.User;

import java.util.List;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    List<Entrega> findByCodEstado(String codEstado);

    List<Entrega> findByRepartidor(User repartidor);

}
