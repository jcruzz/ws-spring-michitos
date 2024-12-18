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
@Table(name = "p_persona", schema = "e_web_shop")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ws_persona_generator")
    @SequenceGenerator(name = "seq_ws_persona_generator", sequenceName = "seq_id_persona", schema = "e_web_shop", allocationSize = 1)
    @Column(name = "id_persona")
    private Long idPersona;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "apellido_casada")
    private String apellidoCasada;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "coordenada_x")
    private String coordenadaX;

    @Column(name = "coordenada_y")
    private String coordenadaY;

    @Column(name = "cod_estado_civil")
    private String codEstadoCivil;

    @Column(name = "cod_tipo_identificacion")
    private String codTipoIdentificacion;

    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;

    @Column(name = "numero_contacto")
    private String numeroContacto;

    @Column(name = "fec_registro")
    private Date fecRegistro;

    @Column(name = "cod_estado")
    private String codEstado;

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoCasada() {
        return apellidoCasada;
    }

    public void setApellidoCasada(String apellidoCasada) {
        this.apellidoCasada = apellidoCasada;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(String coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public String getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(String coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(String codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public String getCodTipoIdentificacion() {
        return codTipoIdentificacion;
    }

    public void setCodTipoIdentificacion(String codTipoIdentificacion) {
        this.codTipoIdentificacion = codTipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
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
        return "Persona [idPersona=" + idPersona + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno
                + ", apellidoMaterno=" + apellidoMaterno + ", apellidoCasada=" + apellidoCasada + ", direccion="
                + direccion + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", codEstadoCivil="
                + codEstadoCivil + ", codTipoIdentificacion=" + codTipoIdentificacion + ", numeroIdentificacion="
                + numeroIdentificacion + ", numeroContacto=" + numeroContacto + ", fecRegistro=" + fecRegistro
                + ", codEstado=" + codEstado + "]";
    }

}
