package Modelos;

public class Comun extends TipoHabitacion{
    private float precio;

    public Comun(float precioPorDia, String idHabitacion, String capacidad) {
        super(precioPorDia, idHabitacion, capacidad);
        this.precio = 0.0f; // Precio inicializado a 0 por defecto
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public float getPrecio() {
        return precio;
    }
}
