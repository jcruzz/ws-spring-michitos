package org.utb.vcp.model.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "f_usuario", schema = "e_web_shop")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ws_usuario_generator")
    @SequenceGenerator(name = "seq_ws_usuario_generator", sequenceName = "seq_id_usuario", schema = "e_web_shop", allocationSize = 1)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "email_usuario")
    private String emailUsuario;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "id_persona")
    private Long idPersona;

    @Column(name = "cod_estado")
    private String codEstado;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "f_r_usuario_rol", schema = "e_web_shop", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String username, String email, String password) {
        this.username = username;
        this.emailUsuario = email;
        this.password = password;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", emailUsuario=" + emailUsuario + ", password=" + password
                + ", username=" + username + ", idPersona=" + idPersona + ", codEstado=" + codEstado + ", roles="
                + roles + "]";
    }
}
