package org.utb.vcp.model.payload.response;

public class RepartidorResponse {
    private Long idUsuario;
    private String nombreUsuario;
    private String nombreCompleto;
    private String nombreRol;

    public RepartidorResponse() {
    }

    public RepartidorResponse(
            Long idUsuario,
            String nombreUsuario,
            String nombreCompleto,
            String nombreRol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.nombreRol = nombreRol;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public String toString() {
        return "RepartidorResponse [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", nombreCompleto="
                + nombreCompleto + ", nombreRol=" + nombreRol + "]";
    }

}
