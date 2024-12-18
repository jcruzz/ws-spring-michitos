package org.utb.vcp.controller;

import java.util.ArrayList;
import java.util.Date;
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
import org.utb.vcp.model.entity.Categoria;
import org.utb.vcp.model.entity.Producto;
import org.utb.vcp.model.payload.dto.ProductoPorCantidad;
import org.utb.vcp.model.payload.request.SaveProductRequest;
import org.utb.vcp.model.payload.request.VentaRequest;
import org.utb.vcp.model.payload.response.MessageResponse;
import org.utb.vcp.repository.CategoriaRepository;
import org.utb.vcp.repository.entity.DominioFijoRepository;
import org.utb.vcp.repository.entity.ProductoRepository;
import org.utb.vcp.repository.entity.ProveedorRepository;

@RestController
@RequestMapping("/api/product")
public class ProductoController {
    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class.getName());

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    DominioFijoRepository dominioFijoRepository;

    @Autowired
    ProveedorRepository proveedorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<?> getAllProducts() {
        logger.info("---------------------- OBTAIN DATA PRODUCT ----------------------");
        try {
            List<Producto> resp = productoRepository.findByEstadoOrderByNombreProductoAsc("ACT");
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            logger.error("Error: " + e);
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PostMapping(value = "/producto", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getProducto(@RequestBody VentaRequest ventaRequest) {
        logger.info("---------------------- OBTAIN DATA PRODUCT ----------------------");
        logger.info(ventaRequest.toString());
        try {
            Producto resp = productoRepository.findByIdProducto(ventaRequest.getIdVenta());
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            logger.error("Error: " + e);
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveProducto(@RequestBody SaveProductRequest productRequest) {
        try {
            List<Categoria> listCategoria = new ArrayList<Categoria>();
            Categoria categoria = categoriaRepository.findByIdCategoria(productRequest.getIdCategoria());
            listCategoria.add(categoria);

            Producto producto = new Producto();
            producto.setNombreProducto(productRequest.getNombreProducto());
            producto.setCantidadstock(productRequest.getCantidadStock());
            producto.setPrecioProducto(productRequest.getPrecioProducto());
            producto.setDescripcion(productRequest.getDescripcion());
            producto.setCostoProducto(productRequest.getCostoProducto());
            // producto.setCodUnidadMedida(productRequest.getCodUnidadMedida());
            producto.setImagenReferencial(productRequest.getImagenReferencial());
            producto.setProveedor(proveedorRepository.findByIdProveedor(productRequest.getIdProveeedor()));
            producto.setCategoria(categoriaRepository.findByIdCategoria(productRequest.getIdCategoria()));
            producto.setFecRegistro(new Date());
            producto.setEstado("ACT");

            return ResponseEntity.ok(productoRepository.save(producto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateProduct(@RequestBody Producto productRequest) {
        try {
            productRequest.setFecRegistro(new Date());
            productRequest.setEstado("ACT");
            return ResponseEntity.ok(productoRepository.save(productRequest));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @PutMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deleteProduct(@RequestBody VentaRequest product) {
        try {
            Producto producto = productoRepository.findByIdProducto(product.getIdVenta());
            producto.setEstado("INA");
            return ResponseEntity.ok(productoRepository.save(producto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }

    @GetMapping(value = "/chart-producto", produces = "application/json")
    public ResponseEntity<?> obtenerChartProductos() {
        try {
            List<Object[]> resultado = productoRepository.obtenerProductosPorCantidad();
            List<ProductoPorCantidad> productoPorCantidads = new ArrayList<>();

            for (Object[] fila : resultado) {
                String producto = (String) fila[0];
                Long cantidad = ((Number) fila[1]).longValue();

                productoPorCantidads.add(new ProductoPorCantidad(producto, cantidad));
            }

            return ResponseEntity.ok(productoPorCantidads);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body(new MessageResponse("Error: Internal Server Error"));
        }
    }
}