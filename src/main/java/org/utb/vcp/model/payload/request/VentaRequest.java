package org.utb.vcp.model.payload.request;

public class VentaRequest {
    private Long idVenta;

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public String toString() {
        return "VentaRequest [idVenta=" + idVenta + "]";
    }

}
