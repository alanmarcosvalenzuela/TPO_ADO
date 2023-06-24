package Modelos;

public class DiasAntes implements EstrategiaPromocion{
    private Float porcentaje;

    public DiasAntes(Float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Float getPorcentaje() {
        return porcentaje;
    }

    @Override
    public Float implementarPromocion() {
        // Ejemplo de aplicación de promoción:
        Float descuento = 0.0f; // TODO: Valor que viene de otra clase.
        return descuento;
    }
}
