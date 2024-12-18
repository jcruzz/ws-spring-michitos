package org.utb.vcp.model.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "f_detalle_venta", schema = "e_web_shop")
public class Detalleventa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ws_detalle_venta_generator")
    @SequenceGenerator(name = "seq_ws_detalle_venta_generator", sequenceName = "seq_id_detalle_venta", schema = "e_web_shop", allocationSize = 1)
    @Column(name = "id_detalle_venta")
    private Long idDetalleVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta", nullable = false)
    @JsonBackReference
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad")
    private Long cantidad;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "fec_registro")
    private Date fecRegistro;

    @Column(name = "cod_estado")
    private String codEstado;

    public Long getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Long idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    @Override
    public String toString() {
        return "Detalleventa [idDetalleVenta=" + idDetalleVenta + ", venta=" + venta + ", producto=" + producto
                + ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + ", fecRegistro=" + fecRegistro
                + ", codEstado=" + codEstado + "]";
    }

}
