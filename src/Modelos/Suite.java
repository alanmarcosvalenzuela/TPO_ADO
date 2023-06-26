package Modelos;

public class Suite extends TipoHabitacion {
    public static Suite instanciaSuite;
    public String descripcion = "Suite";
    private float precioSuite = 70.f;

    private Suite() {
        super();
    }

    // Patrón Singleton
    public static Suite getInstancia() {
        if (instanciaSuite == null) {
            instanciaSuite = new Suite();
        }
        return instanciaSuite;
    }

    public void setPrecio(Float precioSuite) {
        this.precioSuite = precioSuite;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public float getPrecio() {
        return precioSuite + this.getPrecioPorDia();
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}
