package Modelos;

public class Pagado implements EstadoPago{
    @Override
    public void procesarPago(Pago pago) {
        // Lógica para procesar el pago cuando está pagado
        // Aquí puedes realizar las acciones correspondientes al estado de pago pagado
    }

    @Override
    public String getEstadoPago() {
        return "Pagado";
    }
}
