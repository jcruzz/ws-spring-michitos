package org.utb.vcp.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utb.vcp.model.entity.Cliente;
import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
   List<Cliente> findByCodEstado(String codEstado); 
   Cliente findByIdCliente(Long idCliente);
}
