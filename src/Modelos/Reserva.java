package Modelos;

// imports
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String idReserva;
    private LocalDate fechaCheckIn;
    private LocalDate fechaCheckOut;
    private Cliente cliente;
    private List<Huesped> huespedes;
    private List<TipoExtra> extras;
    private List<Habitacion> habitaciones;
    private Float monto;
    private Pago pago;
    private List<Notificacion> notificaciones;

    public Reserva(String idReserva, LocalDate fechaCheckIn, LocalDate fechaCheckOut, Cliente cliente,
                   List<Huesped> huespedes, List<TipoExtra> extras, List<Habitacion> habitaciones,
                   Float monto, Pago pago, List<Notificacion> notificaciones) {
        this.idReserva = idReserva;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.cliente = cliente;
        this.huespedes = huespedes;
        this.extras = extras;
        this.habitaciones = habitaciones;
        this.monto = monto;
        this.pago = pago;
        this.notificaciones = notificaciones;
    }

    public List<Habitacion> getHabitacionesConReserva(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Habitacion> habitacionesConReserva = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            //TODO //boolean tieneReserva = habitacion.tieneReservaEnFechas(fechaInicio, fechaFin);
            boolean tieneReserva = true;
            if (tieneReserva) {
                habitacionesConReserva.add(habitacion);
            }
        }
        return habitacionesConReserva;
    }
}