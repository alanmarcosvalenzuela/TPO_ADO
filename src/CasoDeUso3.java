import Controllers.HabitacionController;
import Modelos.Comun;
import Modelos.Habitacion;
import Modelos.Suite;

import java.util.List;

public class CasoDeUso3 {
    public static void ejecutar(HabitacionController habitacionController) {
        // Código correspondiente al Caso de Uso 3
        System.out.println();
        System.out.println("-------------- CASO DE USO 3 : BUSCAR HABITACIONES SEGÚN EL CRITERIO SOLICITADO --------------");

        Comun habitacionComun = Comun.getInstancia();
        Suite habitacionSuite = Suite.getInstancia();

        // Obtengo coincidencias para las habitaciones según los filtros del parámetro.
        // Nota: Capacidad y precio es considerado como el mínimo en la búsqueda
        List<Habitacion> habitacionesFiltradas = habitacionController.getTodasLasHabitacionesConFiltro(null, 2, 120.f, true);

        // Imprimir lista de habitaciones según filtro
        System.out.println("Las siguientes habitaciones cumplen con los filtros proporcionados: ");
        for (Habitacion habitacion : habitacionesFiltradas) {
            System.out.println("Número de habitación: " + habitacion.getNroHabitacion());
            System.out.println("Tipo de habitación: " + habitacion.getTipoHabitacion().getDescripcion());
            System.out.println("Capacidad: " + habitacion.getCapacidad());
            System.out.println("Precio: " + habitacion.getPrecioHabitacion());
            System.out.println("Disponibilidad: " + (habitacion.isEstaHabilitada() ? "Disponible" : "No disponible"));
            System.out.println("------------------------");
        }

    }
}
