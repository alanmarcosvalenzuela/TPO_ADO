package Controllers;

import Modelos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class ReservaController {
    private List<Reserva> reservas;

    public ReservaController() {
        this.reservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Habitacion> getHabitacionesDisponibles(LocalDate fechaInicio, LocalDate fechaFin, int cantidadPersonas, TipoHabitacion tipo, List<TipoExtra> extras) {
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        /* TODO
        for (Habitacion habitacion : ) {
            if () {
                habitacionesDisponibles.add(habitacion);
            }
        }
        */
        return habitacionesDisponibles;
    }

    public void cancelarReservasNoPagas() {
        CronJob.cancelarReservasNoPagas();
    }
}
