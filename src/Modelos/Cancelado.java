package Modelos;

public class Cancelado implements EstadoPago{
    @Override
    public void procesarPago(Pago pago) {
        // Lógica para procesar el pago cuando está cancelado
        // Aquí puedes realizar las acciones correspondientes al estado de pago cancelado
    }

    @Override
    public String getEstadoPago() {
        return "Cancelado";
    }
}
