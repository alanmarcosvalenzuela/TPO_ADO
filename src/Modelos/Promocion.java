package Modelos;

public class Promocion {
    private Integer idPromocion;
    private String tipo;
    private Float porcentaje;
    private EstrategiaPromocion estrategia;

    public Promocion(Integer idPromocion, String tipo, Float porcentaje, EstrategiaPromocion estrategia) {
        this.idPromocion = idPromocion;
        this.tipo = tipo;
        this.porcentaje = porcentaje;
        this.estrategia = estrategia;
    }

    public Integer getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public EstrategiaPromocion getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaPromocion estrategia) {
        this.estrategia = estrategia;
    }

    public Integer getPrecio() {
        // Ejemplo de cálculo de precio con descuento:
        Integer precioBase = 0;/* Obtener el precio base */;
        Float descuento = precioBase * porcentaje;
        Integer precioConDescuento = precioBase - Math.round(descuento);

        return precioConDescuento;
    }

    public void cambiarEstrategia(EstrategiaPromocion estrategia) {
        this.estrategia = estrategia;
    }

    public Float implementarPromocion() {
        float valorPromocion = 0.0f; // TODO: el método viene de Factura
        return valorPromocion;
    }
}
