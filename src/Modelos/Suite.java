package Modelos;

public class Suite extends TipoHabitacion {
    public static Suite instanciaSuite;
    public String descripcion = "Suite";
    private float precioSuite = 70.f;

    private Suite(float precioPorDia) {
        super(precioPorDia);
    }

    // Patrón Singleton
    public static Suite getInstancia() {
        if (instanciaSuite == null) {
            instanciaSuite = new Suite(100.0f);
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
        return precioSuite + 100.0f;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}
