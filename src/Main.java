import Controllers.ClienteController;
import Controllers.HabitacionController;
import Modelos.*;

import java.util.ArrayList;
import java.util.Arrays;
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

        // Crear Habitaciones, por defecto, habilitada en false
        habitacionController.agregarHabitacion("1", 100, 3, habitacionComun, false);
        habitacionController.agregarHabitacion("2", 200, 2, habitacionSuite, false);
        habitacionController.agregarHabitacion("3", 201, 2, habitacionComun, false);
        habitacionController.agregarHabitacion("4", 301, 4, habitacionComun, false);

        // Modifico habitación de encontrar id
        habitacionController.modificarHabitacion("2", 225, 2, null, false);

        // Busco instancia habitación por id para eliminar
        Habitacion habitacionEliminar = habitacionController.buscarHabitacionPorId("3");
        // Elimino la instancia de habitación
        habitacionController.eliminarHabitacion(habitacionEliminar);


        // Imprimir lista de habitaciones TODO: Otro caso de uso Reporte
        List<Habitacion> habitaciones = habitacionController.getHabitaciones();
        for (Habitacion habitacion : habitaciones) {
            System.out.println("Nro Habitación: " + habitacion.getNroHabitacion() + " - Tipo: " + habitacion.getTipoHabitacion().getDescripcion());
        }
    }
}