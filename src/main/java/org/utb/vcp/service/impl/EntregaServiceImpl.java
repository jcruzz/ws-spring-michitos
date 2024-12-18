package org.utb.vcp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.utb.vcp.model.entity.Entrega;
import org.utb.vcp.repository.entity.EntregaRepository;
import org.utb.vcp.service.EntregaService;

@Service
public class EntregaServiceImpl implements EntregaService{

    @Autowired
    private EntregaRepository entregaRepository;

    @Override
    @Transactional
    public Entrega updateEntrega(Entrega entrega) {
        return entregaRepository.save(entrega);
    }
    
}
