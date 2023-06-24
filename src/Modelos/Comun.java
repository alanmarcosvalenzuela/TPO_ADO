package Modelos;

public class Comun extends TipoHabitacion{
    public static Comun instanciaComun;
    public String descripcion = "Común";
    private float precioComun = 30.f;


     private Comun(float precioPorDia) {
        super(precioPorDia);
    }

    // Patrón Singleton
    public static Comun getInstancia() {
        if (instanciaComun == null) {
            instanciaComun = new Comun(100.0f);
        }
        return instanciaComun;
    }

    public void precioComun(float precioComun) {
        this.precioComun = precioComun;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public float getPrecio() {
        return precioComun;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}
