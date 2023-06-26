package Controllers;

import Modelos.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
public class FacturaController {
    private List<Factura> facturas;

    public FacturaController() {
        facturas = new ArrayList<>();
    }

    public void agregarFactura(String idFactura, LocalDate fechaEmision, Cliente cliente, Reserva reserva,
                               String descripcion, List<Promocion> promociones) {

        Factura factura = new Factura(idFactura, fechaEmision, cliente, reserva, descripcion, promociones);

        TipoHabitacion tipoHabitacion = reserva.getHabitaciones().get(0).getTipoHabitacion();

        // Obtener el precio base del tipo de habitación
        float precioBase = tipoHabitacion.getPrecioPorDia();

        // Calcular el descuento por promoción
        float descuentoTotal = 0.0f;

        LocalDate fechaActual = LocalDate.now();

        if (promociones != null && !promociones.isEmpty()) {
            for (Promocion promocion : promociones) {
                Integer diasAnticipacion = obtenerDiasAnticipacion(reserva.getFechaCheckIn());
                Float descuentoParcial = promocion.implementarPromocion(diasAnticipacion);
                descuentoTotal += descuentoParcial;
            }
        }

        // Aplicar los descuentos al precio base
        float precioConDescuento = precioBase - (precioBase * descuentoTotal);
        precioConDescuento = Math.round(precioConDescuento * 100) / 100.0f;

        Integer cantidadDiasReserva = reserva.calcularDiasReserva();

        float precioFinal = precioConDescuento*cantidadDiasReserva;

        factura.setMonto(precioFinal);

        facturas.add(factura);

        this.enviarFactura(cliente, factura, precioFinal);

    }

    public void eliminarFactura(Factura factura) {
        facturas.remove(factura);
    }

    public void modificarFactura(Factura facturaExistente, Factura facturaModificada) {
        int index = facturas.indexOf(facturaExistente);
        if (index != -1) {
            facturas.set(index, facturaModificada);
        }
    }

    public void enviarFactura(Cliente cliente, Factura factura, Float montoAPagar) {
        System.out.println("Enviando factura al cliente " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Factura ID: " + factura.getIdFactura());
        System.out.println("Monto: $" + montoAPagar);
        EstrategiaContacto metodoContacto = cliente.obtenerMetodoContacto();
        metodoContacto.enviarNotificacion("Se ha generado una nueva factura: " + factura.getIdFactura());
    }

    public void modificarPromocion(Promocion promocion, Factura factura) {
        System.out.println("Modificando promoción de la factura " + factura.getIdFactura());
    }

    public Factura buscarFacturaPorId(String idFactura) {
        for (Factura factura : facturas) {
            if (factura.getIdFactura().equals(idFactura)) {
                return factura;
            }
        }
        return null; // Cliente no encontrado
    }

    public static Integer obtenerDiasAnticipacion(LocalDate fechaCheckIn) {
        // Obtiene la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Calcula la diferencia en días entre la fecha actual y la fecha de check-in
        long diasAnticipacion = ChronoUnit.DAYS.between(fechaActual, fechaCheckIn);

        // Convierte el resultado a Integer
        Integer diasAnticipacionInteger = Math.toIntExact(diasAnticipacion);

        return diasAnticipacionInteger;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
}
