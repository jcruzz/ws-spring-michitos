package org.utb.vcp.model.payload.dto;

public class ProductoPorCantidad {
    private String producto;
    private Long cantidad;

    public ProductoPorCantidad() {
    }

    public ProductoPorCantidad(String producto, Long cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoPorCantidad [producto=" + producto + ", cantidad=" + cantidad + "]";
    }

}
