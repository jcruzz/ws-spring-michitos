package org.utb.vcp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utb.vcp.model.entity.User;
import org.utb.vcp.model.payload.request.DataUserRequest;
import org.utb.vcp.model.payload.request.VentaRequest;
import org.utb.vcp.model.payload.response.MessageResponse;
import org.utb.vcp.model.payload.response.RepartidorResponse;
import org.utb.vcp.repository.entity.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getDataUser(@RequestBody DataUserRequest dataUserRequest) {
        logger.info("---------------------- OBTAIN DATA USER ----------------------");
        logger.info(dataUserRequest.toString());
        try {
            User user = userRepository.findByUsername(dataUserRequest.getUsername());
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            logger.error("Error: " + e);
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Username not found"));
        }
    }

    @GetMapping(value = "/usuarios", produces = "application/json")
    public ResponseEntity<?> getUsers() {
        try {
            List<User> resp = userRepository.findAll();
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Username not found"));
        }
    }

    @PostMapping(value = "/obtener-usuario", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getUser(@RequestBody VentaRequest request) {
        try {
            User resp = userRepository.findByIdUsuario(request.getIdVenta());
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Username not found"));
        }
    }

    @GetMapping(value = "/obtener-repartidor", produces = "application/json")
    public ResponseEntity<?> getRepartidores() {
        try {
            List<Object[]> resultado = userRepository.obtenerUsuariosPorRol();
            List<RepartidorResponse> resp = new ArrayList<>();

            for (Object[] fila : resultado) {
                Long idUsuario = ((Number) fila[0]).longValue();
                String nombreUsuario = (String) fila[1];
                String nombreCompleto = (String) fila[2];
                String nombreRol = (String) fila[3];

                resp.add(new RepartidorResponse(idUsuario, nombreUsuario, nombreCompleto, nombreRol));
            }
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Username not found"));
        }
    }

    @PutMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deleteUser(@RequestBody VentaRequest request) {
        System.out.println(request.getIdVenta());
        try {
            User user = userRepository.findByIdUsuario(request.getIdVenta());
            user.setCodEstado("INA");
            return (ResponseEntity.ok(userRepository.save(user)));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Username not found"));
        }
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try {
            return (ResponseEntity.ok(userRepository.save(user)));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Username not found"));
        }
    }
}
