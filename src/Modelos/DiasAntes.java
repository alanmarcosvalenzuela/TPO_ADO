package Modelos;

public class DiasAntes implements EstrategiaPromocion{

    private static DiasAntes diasAntesInstancia;
    private Float descuentoAlMenos15Dias;
    private Float descuentoMas60Dias;

    private DiasAntes() {
        this.descuentoAlMenos15Dias = 0.15f; // Valor por defecto para descuentoMenos15Dias
        this.descuentoMas60Dias = 0.20f; // Valor por defecto para descuentoMas60Dias
    }

    public static DiasAntes obtenerInstanciaDiasAntes() {
        if (diasAntesInstancia == null) {
            diasAntesInstancia = new DiasAntes();
        }
        return diasAntesInstancia;
    }

    public Float getDescuentoAlMenos15Dias() {
        return descuentoAlMenos15Dias;
    }

    public Float getDescuentoMas60Dias() {
        return descuentoMas60Dias;
    }

    public void setDescuentoAlMenos15Dias(Float descuentoAlMenos15Dias) {
        this.descuentoAlMenos15Dias = descuentoAlMenos15Dias;
    }

    public void setDescuentoMas60Dias(Float descuentoMas60Dias) {
        this.descuentoMas60Dias = descuentoMas60Dias;
    }

    @Override
    public Float implementarPromocion(Integer diasAnticipacion) {
        Float descuento = 0.0f;
        if (diasAnticipacion >= 15 && diasAnticipacion < 60) {
            descuento = Math.round(descuentoAlMenos15Dias * 100) / 100.0f;// Descuento del 15% si la reserva se efectúa 15 días antes o menos
        } else if (diasAnticipacion >= 60) {
            descuento = Math.round(descuentoMas60Dias * 100) / 100.0f;// Descuento adicional del 20% si la reserva se efectúa con más de 2 meses de anticipación
        }
        return descuento;
    }
}
