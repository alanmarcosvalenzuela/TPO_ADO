import Controllers.ClienteController;
import Controllers.FacturaController;
import Controllers.HabitacionController;
import Controllers.ReservaController;
import Modelos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CasoDeUso4 {
    public static void ejecutar(ClienteController clienteController, HabitacionController habitacionController, ReservaController reservaController, FacturaController facturaController) {
        // Código correspondiente al Caso de Uso 4
        System.out.println();
        System.out.println("-------------- CASO DE USO 4 : RESERVAR Y CANCELAR HABITACIONES - ENVIAR FACTURAS Y NOTIFICACIONES --------------");

        // Buscar cliente con id 2 para realizar reserva
        Cliente clienteReserva = clienteController.buscarClientePorId("2");

        // Crear lista de huespedes
        List<Huesped> huespedes = new ArrayList<>();
        huespedes.add(new Huesped(clienteReserva.getDni(), clienteReserva.getNombre(), clienteReserva.getApellido()));
        huespedes.add(new Huesped("35889784", "Sandra", "Arias"));

        // Crear lista de extras que solicita el cliente
        List<TipoExtra> extras = new ArrayList<>();
        extras.add(TipoExtra.SERVICIO_DESPERTADOR);
        extras.add(TipoExtra.TV);

        // Crear lista de habitaciones para la reserva
        Habitacion habitacionReservar = habitacionController.buscarHabitacionPorId("2");
        List<Habitacion> habitacionesReservar = new ArrayList<>();
        habitacionesReservar.add(habitacionReservar);

        // Crear notificaciones para la reserva
        List<Notificacion> notificaciones = new ArrayList<>();
        notificaciones.add(new Notificacion("NOT001", "Se ha realizado la reserva", clienteReserva));

        // Agregar la reserva utilizando el controlador
        reservaController.agregarReserva("RES001", LocalDate.of(2023, 6, 26), LocalDate.of(2023, 6, 30), clienteReserva, huespedes, extras, habitacionesReservar, notificaciones);

        // Obtener la instancia de promoción por días de anticipación
        DiasAntes promocionDiasAntes = DiasAntes.obtenerInstanciaDiasAntes();

        // Inicilizar instancia de promoción y agregar a lista de promociones
        Promocion promocion = new Promocion(1, "Promoción por días de antecedencia en compra", promocionDiasAntes);
        List<Promocion> promociones = new ArrayList<>();
        promociones.add(promocion);

        // Buscar reserva por id a través del controlador
        Reserva reservaFactura = reservaController.buscarReservaPorId("RES001");

        // Agregar factura al controller
        facturaController.agregarFactura("FAC001", LocalDate.now(), reservaFactura.getCliente(), reservaFactura, "Factura nueva", promociones);

        // Buscar factura por ID
        Factura facturaPago = facturaController.buscarFacturaPorId("FAC001");

        // Crear instancia de pago - Se inicializa como pendiente de pago
        Pago pago = new Pago("PAG001", TipoPago.Transferencia, facturaPago, new PendienteDePago());
        reservaFactura.setPago(pago);


        // Cliente paga la factura
        System.out.println();
        System.out.println("Se Realiza el pago: ");
        System.out.println();
        clienteController.realizarPago(facturaPago);

    }
}
