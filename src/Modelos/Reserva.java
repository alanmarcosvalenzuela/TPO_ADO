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
    private Pago pago;
    private List<Notificacion> notificaciones;

    public Reserva(String idReserva, LocalDate fechaCheckIn, LocalDate fechaCheckOut, Cliente cliente,
                   List<Huesped> huespedes, List<TipoExtra> extras, List<Habitacion> habitaciones, List<Notificacion> notificaciones) {
        this.idReserva = idReserva;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.cliente = cliente;
        this.huespedes = huespedes;
        this.extras = extras;
        this.habitaciones = habitaciones;
        this.notificaciones = notificaciones;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(LocalDate fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    public LocalDate getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(LocalDate fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Huesped> getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(List<Huesped> huespedes) {
        this.huespedes = huespedes;
    }

    public List<TipoExtra> getExtras() {
        return extras;
    }

    public void setExtras(List<TipoExtra> extras) {
        this.extras = extras;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
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
