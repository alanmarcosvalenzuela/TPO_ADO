import Controllers.HabitacionController;
import Modelos.Comun;
import Modelos.Habitacion;
import Modelos.Suite;

import java.util.List;

public class CasoDeUso2 {
    public static void ejecutar(HabitacionController habitacionController) {
        // Código correspondiente al Caso de Uso 2
        System.out.println();
        System.out.println("-------------- CASO DE USO 2 : CARGAR HABITACIONES Y DISPONIBILIDAD --------------");

        // Obtengo única instancia de tipo de habitaciones (Singleton)
        Comun habitacionComun = Comun.getInstancia();
        Suite habitacionSuite = Suite.getInstancia();

        // Crear Habitaciones, por defecto en creación habilitada en true
        // Habitación 1
        habitacionController.agregarHabitacion("1", 100, 3, habitacionComun, true);

        // Habitación 2
        habitacionController.agregarHabitacion("2", 200, 2, habitacionSuite, true);

        // Habitación 3
        habitacionController.agregarHabitacion("3", 201, 2, habitacionComun, true);

        // Habitación 4
        habitacionController.agregarHabitacion("4", 301, 4, habitacionComun, true);

        // Habitación 5
        habitacionController.agregarHabitacion("5", 102, 1, habitacionSuite, true);

        // Habitación 6
        habitacionController.agregarHabitacion("6", 202, 2, habitacionSuite, true);

        // Habitación 7
        habitacionController.agregarHabitacion("7", 203, 2, habitacionComun, true);

        // Habitación 8
        habitacionController.agregarHabitacion("8", 302, 3, habitacionComun, true);

        // Modificar habitación según su id
        habitacionController.modificarHabitacion("2", 225, 2, null, true);

        // Buscar instancia habitación por id
        Habitacion habitacionEliminar = habitacionController.buscarHabitacionPorId("3");

        // Eliminar la instancia de habitación
        habitacionController.eliminarHabitacion(habitacionEliminar);

        // Imprimir lista de habitaciones actualizada
        List<Habitacion> habitaciones = habitacionController.getHabitaciones();

        System.out.println("Lista de Habitaciones: ");
        for (Habitacion habitacion : habitaciones) {
            System.out.println("Nro Habitación: " + habitacion.getNroHabitacion() + " - Tipo: " + habitacion.getTipoHabitacion().getDescripcion() + " - Capacidad: " + habitacion.getCapacidad());
        }

    }
}
