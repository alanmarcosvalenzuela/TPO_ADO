package Modelos;

import java.time.LocalDate;
import java.util.List;

public class Pago {
    private String idPago;
    private double monto;
    private TipoPago metodoPago;
    private Factura factura;
    private EstadoPago estadoPago;
    private AdapterPago adapterPago;

    public Pago(String idPago, TipoPago metodoPago, Factura factura, EstadoPago estadoPago) {
        this.idPago = idPago;
        this.monto = 0.f;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.factura = factura;
        this.estadoPago = estadoPago;
        this.adapterPago = new AdapterMercadoPago();
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public TipoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(TipoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public AdapterPago getAdapterPago() {
        return adapterPago;
    }

    public void setAdapterPago(AdapterPago adapterPago) {
        this.adapterPago = adapterPago;
    }

    public void realizarPago() {

        // Realizar Aviso Mercado Pago
        adapterPago.realizarPago();

        // Actualizar el estado de pago a "pagado"
        this.cambiarEstadoPago(new Pagado());

        // Actualizar el monto del pago
        this.setMonto(factura.getMonto());

        Cliente cliente = this.getFactura().getCliente();
        Reserva reserva = this.getFactura().getReserva();

        System.out.println("Se ha detectado un cambio en su reserva " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Reserva ID: " + reserva.getIdReserva());
        System.out.println("Estado: " + reserva.getPago().getEstadoPago().getEstadoPago());
        EstrategiaContacto metodoContacto = cliente.obtenerMetodoContacto();
        metodoContacto.enviarNotificacion("Se ha generado un cambio en su reserva: " + reserva.getIdReserva() + " " + reserva.getPago().getEstadoPago().getEstadoPago());

        this.actualizarDisponibilidadHabitacion(reserva);
    }

    public void actualizarDisponibilidadHabitacion(Reserva reserva) {
        if (isCheckInHoy(reserva)) {
            List<Habitacion> habitacionesReserva = reserva.getHabitaciones();
            for (Habitacion habitacion : habitacionesReserva) {
                habitacion.setEstaHabilitada(false);
            }
        }
    }

    public boolean isCheckInHoy(Reserva reserva) {
        LocalDate fechaActual = LocalDate.now();
        return reserva.getFechaCheckIn().isEqual(fechaActual);
    }

    public void cambiarEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getEstado() {
        return estadoPago.getEstadoPago();
    }
}
