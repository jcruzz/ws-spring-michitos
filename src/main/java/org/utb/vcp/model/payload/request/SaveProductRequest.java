package org.utb.vcp.model.payload.request;

public class SaveProductRequest {
    private Long idProducto;
    private String nombreProducto;
    private Long cantidadStock;
    private Double precioProducto;
    private String descripcion;
    private Double costoProducto;
    private String codUnidadMedida;
    private String imagenReferencial;
    private Long idProveeedor;
    private Long idCategoria;

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

    public Long getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Long cantidadStock) {
        this.cantidadStock = cantidadStock;
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

    public String getCodUnidadMedida() {
        return codUnidadMedida;
    }

    public void setCodUnidadMedida(String codUnidadMedida) {
        this.codUnidadMedida = codUnidadMedida;
    }

    public String getImagenReferencial() {
        return imagenReferencial;
    }

    public void setImagenReferencial(String imagenReferencial) {
        this.imagenReferencial = imagenReferencial;
    }

    public Long getIdProveeedor() {
        return idProveeedor;
    }

    public void setIdProveeedor(Long idProveeedor) {
        this.idProveeedor = idProveeedor;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "SaveProductRequest [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto
                + ", cantidadStock=" + cantidadStock + ", precioProducto=" + precioProducto + ", descripcion="
                + descripcion + ", costoProducto=" + costoProducto + ", codUnidadMedida=" + codUnidadMedida
                + ", imagenReferencial=" + imagenReferencial + ", idProveeedor=" + idProveeedor + ", idCategoria="
                + idCategoria + "]";
    }

}
