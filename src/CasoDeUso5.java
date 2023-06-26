import Controllers.ClienteController;
import Controllers.FacturaController;
import Controllers.HabitacionController;
import Controllers.ReservaController;
import Modelos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CasoDeUso5 {
    public static void ejecutar(ClienteController clienteController, HabitacionController habitacionController, ReservaController reservaController, FacturaController facturaController) {
        // Código correspondiente al Caso de Uso 5
        System.out.println();
        System.out.println("-------------- CASO DE USO 5 : ACTUALIZAR PARÁMETROS DE FACTURACIÓN --------------");

        // Buscar cliente con id 4 para realizar reserva
        Cliente clienteReserva = clienteController.buscarClientePorId("4");

        // Crear lista de huespedes
        List<Huesped> huespedes = new ArrayList<>();
        huespedes.add(new Huesped("16458798", "Sofía", "Peralta"));
        huespedes.add(new Huesped("18985625", "Martín", "Pereyra"));

        // Crear lista de extras que solicita el cliente
        List<TipoExtra> extras = new ArrayList<>();
        extras.add(TipoExtra.SERVICIO_DESPERTADOR);
        extras.add(TipoExtra.TV);
        extras.add(TipoExtra.MINIBAR);
        extras.add(TipoExtra.INTERNET);

        // Crear lista de habitaciones para la reserva
        Habitacion habitacionReserva = habitacionController.buscarHabitacionPorId("4");
        List<Habitacion> habitacionesReserva = new ArrayList<>();
        habitacionesReserva.add(habitacionReserva);

        // Crear notificaciones para la reserva
        List<Notificacion> notificaciones = new ArrayList<>();
        notificaciones.add(new Notificacion("NOT002", "Se ha realizado la reserva", clienteReserva));

        // Agregar la reserva utilizando el controlador
        reservaController.agregarReserva("RES002", LocalDate.of(2023, 8, 2), LocalDate.of(2023, 8, 15), clienteReserva, huespedes, extras, habitacionesReserva, notificaciones);

        // Obtener la instancia de promoción por días de anticipación
        DiasAntes promocionDiasAntes = DiasAntes.obtenerInstanciaDiasAntes();

        // Inicilizar instancia de promoción y agregar a lista de promociones
        Promocion promocion = new Promocion(2, "Promoción por días de antecedencia en compra", promocionDiasAntes);
        List<Promocion> promociones = new ArrayList<>();
        promociones.add(promocion);

        // Buscar reserva por id a través del controlador
        Reserva reservaFactura = reservaController.buscarReservaPorId("RES002");

        System.out.println();
        System.out.println("----- Datos de Factura antes de realizar cambios de parámetros -----");

        // Agregar factura al controller
        facturaController.agregarFactura("FAC002", LocalDate.now(), reservaFactura.getCliente(), reservaFactura, "Factura nueva 2", promociones);

        // Buscar factura por ID
        Factura facturaPago = facturaController.buscarFacturaPorId("FAC002");

        // Crear instancia de pago - Se inicializa como pendiente de pago
        Pago pago = new Pago("PAG002", TipoPago.TarjetaDeCredito, facturaPago, new PendienteDePago());
        reservaFactura.setPago(pago);

        // Nuevos valores de descuento
        promocionDiasAntes.setDescuentoAlMenos15Dias(0.30f);
        promocionDiasAntes.setDescuentoMas60Dias(0.60f);

        System.out.println();
        System.out.println("----- Datos de Factura después de realizar cambios de parámetros -----");

        // Agregar factura al controller
        facturaController.agregarFactura("FAC003", LocalDate.now(), reservaFactura.getCliente(), reservaFactura, "Factura nueva 3", promociones);

        // Buscar factura por ID
        Factura facturaPago2 = facturaController.buscarFacturaPorId("FAC003");

        // Crear instancia de pago - Se inicializa como pendiente de pago
        Pago pago2 = new Pago("PAG003", TipoPago.TarjetaDeCredito, facturaPago2, new PendienteDePago());
        reservaFactura.setPago(pago2);
    }
}
