package org.utb.vcp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utb.vcp.model.entity.Cliente;
import org.utb.vcp.model.payload.request.VentaRequest;
import org.utb.vcp.model.payload.response.MessageResponse;
import org.utb.vcp.repository.entity.ClienteRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<?> getAllClientes() {
        try {
            List<Cliente> resp = clienteRepository.findAll();
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @GetMapping(value = "/clientes-activos", produces = "application/json")
    public ResponseEntity<?> getClientesActivos() {
        try {
            List<Cliente> resp = clienteRepository.findByCodEstado("ACT");
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PostMapping(value = "/obtain-cliente", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getCliente(@RequestBody VentaRequest request) {
        try {
            Cliente resp = clienteRepository.findByIdCliente(request.getIdVenta());
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente) {
        System.out.println(cliente);
        try {
            cliente.getPersona().setFecRegistro(new Date());
            cliente.getPersona().setCodEstado("ACT");
            cliente.setIdCliente(null);
            cliente.setCodEstado("ACT");
            cliente.setFecRegistro(new Date());
            return ResponseEntity.ok(clienteRepository.save(cliente));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PutMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deleteCliente(@RequestBody VentaRequest request) {
        try {
            Cliente cliente = clienteRepository.findByIdCliente(request.getIdVenta());
            cliente.setCodEstado("INA");
            return ResponseEntity.ok(clienteRepository.save(cliente));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente) {
        System.out.println(cliente);
        try {
            return ResponseEntity.ok(clienteRepository.save(cliente));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

}
