package Modelos;

public abstract class TipoHabitacion {
    private Float precioPorDia;
    private String idHabitacion;
    private String capacidad;

    public TipoHabitacion(Float precioPorDia, String idHabitacion, String capacidad) {
        this.precioPorDia = precioPorDia;
        this.idHabitacion = idHabitacion;
        this.capacidad = capacidad;
    }

    public Float getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(Float precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public abstract float getPrecio();
}
