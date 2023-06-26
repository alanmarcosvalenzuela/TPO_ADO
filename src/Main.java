import Controllers.ClienteController;
import Controllers.FacturaController;
import Controllers.HabitacionController;
import Controllers.ReservaController;
import Modelos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // CASO DE USO 1: Cargar nuevos clientes

        // Instancia de ClienteController
        ClienteController clienteController = new ClienteController();

        // Cliente 1
        clienteController.agregarCliente("1", "Jorge", "Ramírez", "37989047", TipoContacto.WHATSAPP,
                "1563687954", "jramirez@gmail.com", "Av. Rivadavia 147", "",
                "Buenos Aires", "111", "Argentina", new ArrayList<>());

        // Cliente 2
        clienteController.agregarCliente("2", "Luciana", "Pérez", "38975461", TipoContacto.SMS,
                "1568787411", "lperez@gmail.com", "Av. Independencia 289", "Constitución",
                "Buenos Aires", "123", "Argentina", new ArrayList<>());

        // Cliente 3
        clienteController.agregarCliente("3", "Mario", "Gutierrez", "25897879", TipoContacto.MAIL,
                "1234567890", "mgutierrez@gmail.com", "San Martín 268", "Barrio Centro",
                "Santa Fe", "222", "Argentina", new ArrayList<>());

        // Cliente 4
        clienteController.agregarCliente("4", "Natalia", "López", "25787879", TipoContacto.SMS,
                "1568987447", "nlopez@gmail.com", "Lavalle 101", "Microcentro",
                "Buenos Aires", "134", "Argentina", new ArrayList<>());

        // Modifico cliente de encontrar id
        clienteController.modificarCliente("1", "Jaime", null, null, "42479874", null);

        // Busco instancia cliente por id para eliminar
        Cliente clienteEliminar = clienteController.buscarClientePorId("3");
        // Elimino la instancia de cliente
        clienteController.eliminarCliente(clienteEliminar);

        // Imprimir lista de clientes
        List<Cliente> clientes = clienteController.getClientes();

        System.out.println("Lista de Clientes: ");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getIdCliente() + ": " + cliente.getNombre() + " " + cliente.getApellido());
        }

        // ---------------------------------------------------

        // CASO DE USO 2: Cargar habitaciones y disponibilidad.

        // Crear instancia de HabitacionController
        HabitacionController habitacionController = new HabitacionController();

        // Obtengo única instancia de tipo de habitaciones (Singleton)
        Comun habitacionComun = Comun.getInstancia();
        Suite habitacionSuite = Suite.getInstancia();

        // Crear Habitaciones, por defecto, habilitada en true
        habitacionController.agregarHabitacion("1", 100, 3, habitacionComun, true);
        habitacionController.agregarHabitacion("2", 200, 2, habitacionSuite, true);
        habitacionController.agregarHabitacion("3", 201, 2, habitacionComun, true);
        habitacionController.agregarHabitacion("4", 301, 4, habitacionComun, true);

        // Modifico habitación de encontrar id
        habitacionController.modificarHabitacion("2", 225, 2, null, true);

        // Busco instancia habitación por id para eliminar
        Habitacion habitacionEliminar = habitacionController.buscarHabitacionPorId("3");
        // Elimino la instancia de habitación
        habitacionController.eliminarHabitacion(habitacionEliminar);


        // Imprimir lista de habitaciones TODO: Otro caso de uso Reporte
        List<Habitacion> habitaciones = habitacionController.getHabitaciones();

        System.out.println("Lista de Habitaciones: ");
        for (Habitacion habitacion : habitaciones) {
            System.out.println("Nro Habitación: " + habitacion.getNroHabitacion() + " - Tipo: " + habitacion.getTipoHabitacion().getDescripcion());
        }

        // ---------------------------------------------------

        // CASO DE USO 3: Buscar habitaciones según el criterio solicitado y mostrar datos completos.

        // Obtengo coincidencias para las habitaciones según los filtros del parámetro. Nota: Capacidad y precio es considerado como el mínimo en la búsqueda
        List<Habitacion> habitacionesFiltradas = habitacionController.getTodasLasHabitacionesConFiltro(null, 2, 150.f, false);

        System.out.println("Las siguientes habitaciones cumplen con los filtros proporcionados: ");
        for (Habitacion habitacion : habitacionesFiltradas) {
            System.out.println("Número de habitación: " + habitacion.getNroHabitacion());
            System.out.println("Tipo de habitación: " + habitacion.getTipoHabitacion().getDescripcion());
            System.out.println("Capacidad: " + habitacion.getCapacidad());
            System.out.println("Precio: " + habitacion.getPrecioHabitacion());
            System.out.println("Disponibilidad: " + (habitacion.isEstaHabilitada() ? "Disponible" : "No disponible"));
            System.out.println("------------------------");
        }

        // ---------------------------------------------------

        // CASO DE USO 4: Reservar y cancelar habitaciones presencialmente o vía web -  Enviar facturas y notificaciones a clientes.

        // Crear una instancia del controlador de reserva
        ReservaController reservaController = new ReservaController();

        // Busco instancia cliente para la reserva
        Cliente clienteReservar = clienteController.buscarClientePorId("2");
        List<Huesped> huespedes = new ArrayList<>();
        huespedes.add(new Huesped("11111111", "Huesped 1", "Apellido 1"));
        huespedes.add(new Huesped("22222222", "Huesped 2", "Apellido 2"));
        List<TipoExtra> extras = new ArrayList<>();
        extras.add(TipoExtra.SERVICIO_DESPERTADOR);
        extras.add(TipoExtra.TV);
        // Busco instancia habitación para la reserva
        Habitacion habitacionReservar = habitacionController.buscarHabitacionPorId("2");
        List<Habitacion> habitacionesReservar = new ArrayList<>();
        habitacionesReservar.add(habitacionReservar);

        // Agregar notificaciones a la reserva
        List<Notificacion> notificaciones = new ArrayList<>();
        notificaciones.add(new Notificacion("1", "Se ha realizado la reserva", clienteReservar));

        // Agregar la reserva utilizando el controlador
        reservaController.agregarReserva("123456", LocalDate.of(2023, 6, 26), LocalDate.of(2024, 7, 5), clienteReservar, huespedes, extras, habitacionesReservar, notificaciones);

        // Crear una instancia del controlador de factura
        FacturaController facturaController = new FacturaController();

        // Obtengo la instancia de promoción por días de anticipación
        DiasAntes promocionDiasAntes = DiasAntes.obtenerInstanciaDiasAntes();

        // Inicilizar instancia de promoción
        Promocion promocion = new Promocion(1, "Promoción 1", promocionDiasAntes);
        List<Promocion> promociones = new ArrayList<>();
        promociones.add(promocion);

        Reserva reservaFactura = reservaController.buscarReservaPorId("123456");

        facturaController.agregarFactura("23323", LocalDate.now(), reservaFactura.getCliente(), reservaFactura, "Factura nueva", promociones);

        // Buscar factura por ID
        Factura facturaPago = facturaController.buscarFacturaPorId("23323");

        // Crear instancia de pago
        Pago pago = new Pago("1212", TipoPago.Transferencia, facturaPago, new PendienteDePago());
        reservaFactura.setPago(pago);

        String estadoPago =  reservaFactura.getPago().getEstadoPago().getEstadoPago();
        System.out.println(estadoPago);

        //reservaController.cancelarReserva(reservaFactura);


        String estadoPago2 =  reservaFactura.getPago().getEstadoPago().getEstadoPago();
        System.out.println(estadoPago2);

        clienteController.realizarPago(facturaPago);


        // CASO DE USO 5: Actualizar parámetros de facturación - Enviar facturas y notificaciones a clientes.

        System.out.println("CASO DE USO 5 ------------------------------");

        // Busco instancia cliente para la reserva
        Cliente clienteReserva2 = clienteController.buscarClientePorId("4");
        List<Huesped> huespedes2 = new ArrayList<>();
        huespedes2.add(new Huesped("33333333", "Huesped 3", "Apellido 3"));
        huespedes2.add(new Huesped("44444444", "Huesped 4", "Apellido 4"));
        List<TipoExtra> extras2 = new ArrayList<>();
        extras2.add(TipoExtra.SERVICIO_DESPERTADOR);
        extras2.add(TipoExtra.TV);
        extras2.add(TipoExtra.MINIBAR);
        extras2.add(TipoExtra.INTERNET);
        // Busco instancia habitación para la reserva
        Habitacion habitacionReserva2 = habitacionController.buscarHabitacionPorId("4");
        List<Habitacion> habitacionesReserva2 = new ArrayList<>();
        habitacionesReserva2.add(habitacionReserva2);

        // Agregar notificaciones a la reserva
        List<Notificacion> notificaciones2 = new ArrayList<>();
        notificaciones2.add(new Notificacion("2", "Se ha realizado la reserva", clienteReserva2));

        // Agregar la reserva utilizando el controlador
        reservaController.agregarReserva("7891011", LocalDate.of(2024, 6, 25), LocalDate.of(2024, 7, 5), clienteReservar, huespedes2, extras2, habitacionesReserva2, notificaciones2);

        // Obtengo la instancia de promoción por días de anticipación
        DiasAntes promocionDiasAntes2 = DiasAntes.obtenerInstanciaDiasAntes();

        // Inicilizar instancia de promoción
        Promocion promocion2 = new Promocion(1, "Promoción 1", promocionDiasAntes2);
        List<Promocion> promociones2 = new ArrayList<>();
        promociones2.add(promocion2);

        Reserva reservaFactura2 = reservaController.buscarReservaPorId("7891011");

        facturaController.agregarFactura("58988", LocalDate.now(), reservaFactura2.getCliente(), reservaFactura2, "Factura nueva 2", promociones2);
        Factura facturaPago2 = facturaController.buscarFacturaPorId("58988");
        Pago pago2 = new Pago("1212", TipoPago.TarjetaDeCredito, facturaPago2, new PendienteDePago());
        reservaFactura2.setPago(pago);


        System.out.println("Factura antes de actualizar datos de promocion: ");
        System.out.println("ID : " + facturaPago2.getIdFactura() + " - Descripcion: " + facturaPago2.getDescripcion() + " - Monto: $" + facturaPago2.getMonto());

        // Nuevos valor de descuento
        promocionDiasAntes2.setDescuentoAlMenos15Dias(0.30f);
        promocionDiasAntes2.setDescuentoMas60Dias(0.60f);

        facturaController.agregarFactura("58989", LocalDate.now(), reservaFactura2.getCliente(), reservaFactura2, "Factura nueva 3", promociones2);
        Factura facturaPago3 = facturaController.buscarFacturaPorId("58989");

        System.out.println("Factura después de actualizar datos de promocion: ");
        System.out.println("ID : " + facturaPago3.getIdFactura() + " - Descripcion: " + facturaPago3.getDescripcion() + " - Monto: $" + facturaPago3.getMonto());


        // CASO DE USO 6: Generar un reporte del estado de las habitaciones del hotel (reservadas, disponibles).

        // Reporte de Habitaciones
        habitacionController.reporteHabitaciones();
        // Reporte de Reservas
        reservaController.reporteReservas();
    }
}