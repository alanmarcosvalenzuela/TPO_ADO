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

    public void agregarReserva(String idReserva, LocalDate fechaCheckIn, LocalDate fechaCheckOut, Cliente cliente,
                               List<Huesped> huespedes, List<TipoExtra> extras, List<Habitacion> habitaciones, List<Notificacion> notificaciones) {
        Reserva reserva = new Reserva(idReserva, fechaCheckIn, fechaCheckOut, cliente, huespedes, extras, habitaciones,
                notificaciones);
        reservas.add(reserva);

        // Verificar si es la primera reserva del cliente
        if (cliente.getReservas().isEmpty()) {
            // Es la primera reserva del cliente, realizar acciones adicionales aquí
            System.out.println("Es la primera reserva del cliente. Realizando acciones adicionales...");

            // Enviar un correo de bienvenida al cliente
            Email correoBienvenida = new Email(cliente.getEmail());
            correoBienvenida.enviarNotificacion("¡Bienvenido! Gracias por realizar tu primera reserva: "  + reserva.getIdReserva());
        }
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        // Obtener el pago relacionado
        Pago pagoReserva = reserva.getPago();
        EstadoPago estadoCancelado = new Cancelado();
        // Cambiar estado a cancelado
        pagoReserva.cambiarEstadoPago(estadoCancelado);

        this.enviarCambioReserva(reserva.getCliente(), reserva);
    }

    public void enviarCambioReserva(Cliente cliente, Reserva reserva) {
        System.out.println("Se ha detectado un cambio en su reserva " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Reserva ID: " + reserva.getIdReserva());
        System.out.println("Estado: " + reserva.getPago().getEstadoPago().getEstadoPago());
        EstrategiaContacto metodoContacto = cliente.obtenerMetodoContacto();
        metodoContacto.enviarNotificacion("Se ha generado un cambio en su reserva: " + reserva.getIdReserva() + " " + reserva.getPago().getEstadoPago().getEstadoPago());
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Reserva buscarReservaPorId(String idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIdReserva().equals(idReserva)) {
                return reserva;
            }
        }
        return null; // Cliente no encontrado
    }

    public void cancelarReservasNoPagas() {
        CronJob.cancelarReservasNoPagas(this, reservas);
    }

    public void reporteReservas() {

        List<Reserva> reservas = this.getReservas();

        System.out.println("-------- REPORTE DE RESERVAS --------");

        for (Reserva reserva : reservas){
            System.out.println("ID Reserva: " + reserva.getIdReserva());
            System.out.println("Cliente: " + reserva.getCliente().getNombre() + " " + reserva.getCliente().getApellido());
            System.out.println("Fecha Check In: " + reserva.getFechaCheckIn());
            System.out.println("Fecha Check Out: " + reserva.getFechaCheckOut());
            List<Habitacion> habitaciones = reserva.getHabitaciones();
            List<TipoExtra> extras = reserva.getExtras();
            System.out.println("Habitaciones: ");
            for (Habitacion habitacion : habitaciones){
                System.out.println("- Habitación Nro: " + habitacion.getNroHabitacion());
                System.out.println("- Capacidad: " +habitacion.getCapacidad());
            }
            System.out.println("Extras: ");
            for (TipoExtra extra : extras){
                System.out.println("-" + extra.name());
            }
            System.out.println();
        }
    }
}
