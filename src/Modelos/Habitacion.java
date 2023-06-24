package Modelos;

public class Habitacion {
    private String idHabitacion;
    private Integer nroHabitacion;
    private Integer capacidad;
    private TipoHabitacion tipoHabitacion;
    private boolean estaHabilitada;

    public Habitacion(String idHabitacion, Integer nroHabitacion, Integer capacidad, TipoHabitacion tipoHabitacion) {
        this.idHabitacion = idHabitacion;
        this.nroHabitacion = nroHabitacion;
        this.capacidad = capacidad;
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Integer getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(Integer nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public boolean isEstaHabilitada() {
        return estaHabilitada;
    }

    public void setEstaHabilitada(boolean estaHabilitada) {
        this.estaHabilitada = estaHabilitada;
    }

    public float getPrecioHabitacion() {
        return tipoHabitacion.getPrecio();
    }
}
