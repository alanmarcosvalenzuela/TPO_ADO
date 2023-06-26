package Modelos;

public abstract class TipoHabitacion {
    private Float precioPorDia;

    public TipoHabitacion() {
        this.precioPorDia = 100.f;
    }

    public Float getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(Float precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public abstract float getPrecio();

    public abstract String getDescripcion();
}
