package Modelos;

public class Promocion {
    private Integer idPromocion;
    private String tipo;
    private EstrategiaPromocion estrategia;

    public Promocion(Integer idPromocion, String tipo, EstrategiaPromocion estrategia) {
        this.idPromocion = idPromocion;
        this.tipo = tipo;
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

    public EstrategiaPromocion getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaPromocion estrategia) {
        this.estrategia = estrategia;
    }

    public Integer getPrecio() {
        return 0;
    }

    public void cambiarEstrategia(EstrategiaPromocion estrategia) {
        this.estrategia = estrategia;
    }

    public Float implementarPromocion(Integer diasAnticipacion) {
        if (estrategia != null) {
            return estrategia.implementarPromocion(diasAnticipacion);
        }
        return 0.0f;
    }
}
