package Modelos;

public class PendienteDePago implements EstadoPago{
    @Override
    public void procesarPago(Pago pago) {
        // Lógica para procesar el pago cuando está pendiente
        // Aquí puedes realizar las acciones correspondientes al estado de pago pendiente
    }

    @Override
    public String getEstadoPago() {
        return "Pendiente de pago";
    }
}
