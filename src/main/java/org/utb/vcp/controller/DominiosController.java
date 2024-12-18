package org.utb.vcp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utb.vcp.model.entity.DominioFijo;
import org.utb.vcp.model.entity.Rol;
import org.utb.vcp.model.payload.request.VentaRequest;
import org.utb.vcp.model.payload.response.MessageResponse;
import org.utb.vcp.repository.entity.DominioFijoRepository;
import org.utb.vcp.repository.entity.RolRepository;

@RestController
@RequestMapping("/api/dominio")
public class DominiosController {
    @Autowired
    DominioFijoRepository dominioFijoRepository;

    @Autowired
    RolRepository rolRepository;

    @PostMapping(value = "/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> getDominios(@RequestBody VentaRequest ventaRequest) {
        try {
            List<DominioFijo> resp = dominioFijoRepository.findByIdDefDominioOrderByNombreDominioAsc(ventaRequest.getIdVenta());
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @GetMapping(value = "/obtain-roles", produces = "application/json")
    public ResponseEntity<?> getRoles() {
        try {
            List<Rol> resp = rolRepository.findAll();
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PostMapping(value = "/obtain-rol", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getRol(@RequestBody VentaRequest request) {
        try {
            Rol resp = rolRepository.findByIdRol(request.getIdVenta());
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    // @PostMapping(value = "/dominio", produces = "application/json", consumes =
    // "application/json")
    // public ResponseEntity<?> getDominio(@RequestBody CodDominioRequest
    // codDominioRequest) {

    // }

}
