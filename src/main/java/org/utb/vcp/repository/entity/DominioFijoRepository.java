package org.utb.vcp.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utb.vcp.model.entity.DominioFijo;
import java.util.List;


@Repository
public interface DominioFijoRepository extends JpaRepository<DominioFijo, Long>{
    List<DominioFijo> findByIdDefDominioOrderByNombreDominioAsc(Long idDefDominio);

    DominioFijo findByCodDominio(String codDominio);
}
