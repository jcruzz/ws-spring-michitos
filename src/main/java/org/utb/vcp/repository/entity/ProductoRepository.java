package org.utb.vcp.repository.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.utb.vcp.model.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Producto findByIdProducto(Long idProducto);

    List<Producto> findByEstadoOrderByNombreProductoAsc(String estado);

    @Query(value = """
                SELECT
                    fp.nombre_producto AS producto,
                    SUM(fdv.cantidad) AS cantidad
                FROM e_web_shop.f_detalle_venta fdv
                JOIN e_web_shop.f_producto fp
                    ON fdv.id_producto = fp.id_producto
                GROUP BY fp.nombre_producto
                ORDER BY 2 DESC
                LIMIT 5
            """, nativeQuery = true)
    List<Object[]> obtenerProductosPorCantidad();
}
