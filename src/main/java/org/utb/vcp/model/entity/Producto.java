package org.utb.vcp.model.entity;

import java.util.Date;

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
@Table(name = "f_producto", schema = "e_web_shop")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ws_producto_generator")
    @SequenceGenerator(name = "seq_ws_producto_generator", sequenceName = "seq_id_producto", schema = "e_web_shop", allocationSize = 1)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "cantidad_stock")
    private Long cantidadstock;

    @Column(name = "precio_producto")
    private Double precioProducto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo_producto")
    private Double costoProducto;

    @Column(name = "imagen_referencial")
    private String imagenReferencial;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    @Column(name = "fec_registro")
    private Date fecRegistro;

    @Column(name = "cod_estado")
    private String estado;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Long getCantidadstock() {
        return cantidadstock;
    }

    public void setCantidadstock(Long cantidadstock) {
        this.cantidadstock = cantidadstock;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(Double costoProducto) {
        this.costoProducto = costoProducto;
    }

    public String getImagenReferencial() {
        return imagenReferencial;
    }

    public void setImagenReferencial(String imagenReferencial) {
        this.imagenReferencial = imagenReferencial;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", cantidadstock="
                + cantidadstock + ", precioProducto=" + precioProducto + ", descripcion=" + descripcion
                + ", costoProducto=" + costoProducto + ", imagenReferencial=" + imagenReferencial + ", categoria="
                + categoria + ", proveedor=" + proveedor + ", fecRegistro=" + fecRegistro + ", estado=" + estado + "]";
    }

}
