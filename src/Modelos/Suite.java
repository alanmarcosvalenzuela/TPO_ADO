package Modelos;

public class Suite extends TipoHabitacion {

    private Float precio;
    private Integer numeroHabitacion;

    public Suite(Float precioPorDia, String idHabitacion, String capacidad, Integer numeroHabitacion) {
        super(precioPorDia, idHabitacion, capacidad);
        this.numeroHabitacion = numeroHabitacion;
        this.precio = 0.0f; // Precio inicializado a 0 por defecto
    }

    public Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public float getPrecio() {
        return 0;
    }
}
