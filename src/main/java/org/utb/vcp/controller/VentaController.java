package org.utb.vcp.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utb.vcp.model.entity.Detalleventa;
import org.utb.vcp.model.entity.Venta;
import org.utb.vcp.model.payload.request.VentaRequest;
import org.utb.vcp.model.payload.response.MessageResponse;
import org.utb.vcp.repository.entity.DetalleVentaRepository;
import org.utb.vcp.repository.entity.VentaRepository;

@RestController
@RequestMapping("/api/venta")
public class VentaController {
    private static final Logger logger = LoggerFactory.getLogger(Venta.class.getName());

    @Autowired
    VentaRepository ventaRepository;

    @Autowired
    DetalleVentaRepository detalleVentaRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<?> getAllVentas() {
        logger.info("---------------------- OBTAIN DATA VENTA ----------------------");
        try {
            List<Venta> resp = ventaRepository.findAll();
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            logger.error("Error: " + e);
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PostMapping(value = "/obtain-details-venta", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> getDetailsVenta(@RequestBody VentaRequest ventaRequest) {
        logger.info("---------------------- OBTAIN DATA DETALLE VENTA ----------------------");
        logger.info(ventaRequest.toString());
        try {
            Venta venta = ventaRepository.findByIdVenta(ventaRequest.getIdVenta());
            List<Detalleventa> resp = detalleVentaRepository.findByVenta(venta);
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            logger.error("Error: " + e);
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PostMapping(value = "/venta", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getVenta(@RequestBody VentaRequest ventaRequest) {
        try {
            Venta venta = ventaRepository.findByIdVenta(ventaRequest.getIdVenta());
            return ResponseEntity.ok(venta);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveVenta(@RequestBody Venta venta) {
        try {
            venta.setFecRegistro(new Date());
            for (int i = 0; i < venta.getDetalles().size(); i ++) {
                venta.getDetalles().get(i).setFecRegistro(new Date());
            }
            return ResponseEntity.ok(ventaRepository.save(venta));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }
    
}
