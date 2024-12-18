package org.utb.vcp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utb.vcp.model.entity.Entrega;
import org.utb.vcp.model.entity.User;
import org.utb.vcp.model.payload.response.MessageResponse;
import org.utb.vcp.repository.entity.EntregaRepository;
import org.utb.vcp.service.EntregaService;

@RestController
@RequestMapping("/api/entrega")
public class EntregaController {

    @Autowired
    EntregaRepository entregaRepository;

    @Autowired
    private EntregaService entregaService;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<?> getAllEntregas() {
        try {
            List<Entrega> resp = entregaRepository.findAll();
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PostMapping(value = "/obtener-entregas", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getEntrega(@RequestBody User user) {
        try {
            List<Entrega> resp = entregaRepository.findByRepartidor(user);
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveEntrega(@RequestBody Entrega entrega) {
        try {
            entrega.setCodEstado("PEN");
            entrega.setFecRegistro(new Date());
            return ResponseEntity.ok(entregaRepository.save(entrega));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateEntrega(@RequestBody Entrega entrega) {
        try {
            Entrega resp = entregaService.updateEntrega(entrega);
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }
}
