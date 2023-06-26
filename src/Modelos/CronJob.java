package Modelos;

import Controllers.ReservaController;
import java.util.List;

public class CronJob {
    public static void cancelarReservasNoPagas(ReservaController reservaController, List<Reserva> reservas) {
        System.out.println("Cancelando Reservas No Pagas");

        for (Reserva reserva : reservas){
            if (reserva.getPago().getEstadoPago() instanceof PendienteDePago){
                reservaController.cancelarReserva(reserva);
            }
        }
    }
}
