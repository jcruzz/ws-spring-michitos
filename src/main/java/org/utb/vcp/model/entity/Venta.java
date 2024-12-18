package org.utb.vcp.model.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "f_venta", schema = "e_web_shop")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ws_venta_generator")
    @SequenceGenerator(name = "seq_ws_venta_generator", sequenceName = "seq_id_venta", schema = "e_web_shop", allocationSize = 1)
    @Column(name = "id_venta")
    private Long idVenta;

    @Column(name = "num_comprobante")
    private Long numComprobante;

    @Column(name = "total")
    private Double total;

    @Column(name = "cod_metodo_pago")
    private String codMetodoPago;

    @Column(name = "cod_tipo_venta")
    private String codTipoVenta;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private User user;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Detalleventa> detalles;

    @Column(name = "fec_registro")
    private Date fecRegistro;

    @Column(name = "cod_estado")
    private String estado;

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Long getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(Long numComprobante) {
        this.numComprobante = numComprobante;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCodMetodoPago() {
        return codMetodoPago;
    }

    public void setCodMetodoPago(String codMetodoPago) {
        this.codMetodoPago = codMetodoPago;
    }

    public String getCodTipoVenta() {
        return codTipoVenta;
    }

    public void setCodTipoVenta(String codTipoVenta) {
        this.codTipoVenta = codTipoVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Detalleventa> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalleventa> detalles) {
        this.detalles = detalles;
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
        return "Venta [idVenta=" + idVenta + ", numComprobante=" + numComprobante + ", total=" + total
                + ", codMetodoPago=" + codMetodoPago + ", codTipoVenta=" + codTipoVenta + ", cliente=" + cliente
                + ", user=" + user + ", detalles=" + detalles + ", fecRegistro=" + fecRegistro + ", estado=" + estado
                + "]";
    }

}