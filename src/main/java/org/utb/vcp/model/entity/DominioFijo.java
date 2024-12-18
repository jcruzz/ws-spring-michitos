package org.utb.vcp.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "p_dominio_fijo", schema = "e_web_shop")
public class DominioFijo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ws_dominio_fijo_generator")
    @SequenceGenerator(name = "seq_ws_dominio_fijo_generator", sequenceName = "seq_id_dominio_fijo", schema = "e_web_shop", allocationSize = 1)
    @Column(name = "id_dominio_fijo")
    private Long idDominioFijo;

    @Column(name = "id_def_dominio")
    private Long idDefDominio;

    @Column(name = "nombre_dominio")
    private String nombreDominio;

    @Column(name = "auxiliar")
    private String auxiliar;

    @Column(name = "cod_dominio")
    private String codDominio;

    @Column(name = "descripcion_dominio")
    private String descripcionDominio;

    @Column(name = "fec_registro")
    private Date fecRegistro;

    @Column(name = "cod_estado")
    private String codEstado;

    public Long getIdDominioFijo() {
        return idDominioFijo;
    }

    public void setIdDominioFijo(Long idDominioFijo) {
        this.idDominioFijo = idDominioFijo;
    }

    public Long getIdDefDominio() {
        return idDefDominio;
    }

    public void setIdDefDominio(Long idDefDominio) {
        this.idDefDominio = idDefDominio;
    }

    public String getNombreDominio() {
        return nombreDominio;
    }

    public void setNombreDominio(String nombreDominio) {
        this.nombreDominio = nombreDominio;
    }

    public String getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(String auxiliar) {
        this.auxiliar = auxiliar;
    }

    public String getCodDominio() {
        return codDominio;
    }

    public void setCodDominio(String codDominio) {
        this.codDominio = codDominio;
    }

    public String getDescripcionDominio() {
        return descripcionDominio;
    }

    public void setDescripcionDominio(String descripcionDominio) {
        this.descripcionDominio = descripcionDominio;
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
        return "DominioFijo [idDominioFijo=" + idDominioFijo + ", idDefDominio=" + idDefDominio + ", nombreDominio="
                + nombreDominio + ", auxiliar=" + auxiliar + ", codDominio=" + codDominio + ", descripcionDominio="
                + descripcionDominio + ", fecRegistro=" + fecRegistro + ", codEstado=" + codEstado + "]";
    }

}
