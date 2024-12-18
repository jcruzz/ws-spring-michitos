package org.utb.vcp.model.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "f_entrega", schema = "e_web_shop")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ws_entrega_generator")
    @SequenceGenerator(name = "seq_ws_entrega_generator", sequenceName = "seq_id_entrega", schema = "e_web_shop", allocationSize = 1)
    @Column(name = "id_entrega")
    private Long idEntrega;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    private Venta venta;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private User repartidor;

    @Column(name = "fec_registro")
    private Date fecRegistro;

    @Column(name = "cod_estado")
    private String codEstado;

    public Long getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Long idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public User getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(User repartidor) {
        this.repartidor = repartidor;
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
        return "Entrega [idEntrega=" + idEntrega + ", venta=" + venta + ", repartidor=" + repartidor + ", fecRegistro="
                + fecRegistro + ", codEstado=" + codEstado + "]";
    }

}
