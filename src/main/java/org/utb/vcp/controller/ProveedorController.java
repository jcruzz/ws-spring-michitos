package org.utb.vcp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utb.vcp.model.entity.Proveedor;
import org.utb.vcp.model.payload.request.VentaRequest;
import org.utb.vcp.model.payload.response.MessageResponse;
import org.utb.vcp.repository.entity.ProveedorRepository;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

    @Autowired
    ProveedorRepository proveedorRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<?> getAllProveedor() {
        try {
            List<Proveedor> resp = proveedorRepository.findAll();
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PostMapping(value = "/obtener-proveedor", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getProveedor(@RequestBody VentaRequest request) {
        try {
            Proveedor resp = proveedorRepository.findByIdProveedor(request.getIdVenta());
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }
}
