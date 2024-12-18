package org.utb.vcp.model.entity;

import org.utb.vcp.model.ERole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "f_rol", schema = "e_web_shop")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ws_rol_generator")
    @SequenceGenerator(name = "seq_ws_rol_generator", sequenceName = "seq_id_rol", schema = "e_web_shop", allocationSize = 1)
    @Column(name = "id_rol")
    private Long idRol;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_rol")
    private ERole nombreRol;

    public Rol() {
    }

    public Rol(ERole nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public ERole getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(ERole nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public String toString() {
        return "Rol [idRol=" + idRol + ", nombreRol=" + nombreRol + "]";
    }

}
