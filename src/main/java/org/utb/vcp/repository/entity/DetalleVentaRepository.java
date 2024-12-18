package org.utb.vcp.repository.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utb.vcp.model.entity.Detalleventa;
import org.utb.vcp.model.entity.Venta;

@Repository
public interface DetalleVentaRepository extends JpaRepository<Detalleventa, Long>{
    
    List<Detalleventa> findByVenta(Venta venta);
}
