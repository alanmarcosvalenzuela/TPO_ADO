import Controllers.HabitacionController;
import Controllers.ReservaController;

public class CasoDeUso6 {
    public static void ejecutar(HabitacionController habitacionController, ReservaController reservaController) {
        // Código correspondiente al Caso de Uso 6
        System.out.println();
        System.out.println("-------------- CASO DE USO 6 : GENERAR UN REPORTE DEL ESTADO DE LAS HABITACIONES --------------");

        // Reporte de Habitaciones
        habitacionController.reporteHabitaciones();
        // Reporte de Reservas
        reservaController.reporteReservas();
    }
}
