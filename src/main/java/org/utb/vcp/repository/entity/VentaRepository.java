package org.utb.vcp.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utb.vcp.model.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{
    
    Venta findByIdVenta(Long idVenta);
}
