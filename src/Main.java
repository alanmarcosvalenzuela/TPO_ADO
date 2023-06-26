import Controllers.*;
import Modelos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear Instancia de HotelController
        HotelController hotelController = new HotelController();
        // Crear instancia de ClienteController
        ClienteController clienteController = new ClienteController();
        // Crear instancia de HabitacionController
        HabitacionController habitacionController = new HabitacionController();
        // Crear instancia de ReservaController
        ReservaController reservaController = new ReservaController();
        // Crear instancia de FacturaController
        FacturaController facturaController = new FacturaController();


        // CASO DE USO 1: Cargar nuevos clientes.
        CasoDeUso1.ejecutar(clienteController);

        // CASO DE USO 2: Cargar habitaciones y disponibilidad.
        CasoDeUso2.ejecutar(habitacionController);

        // CASO DE USO 3: Buscar habitaciones según el criterio solicitado y mostrar datos completos.
        CasoDeUso3.ejecutar(habitacionController);

        // CASO DE USO 4: Reservar y cancelar habitaciones presencialmente o vía web -  Enviar facturas y notificaciones a clientes.
        CasoDeUso4.ejecutar(clienteController, habitacionController, reservaController, facturaController);

        // CASO DE USO 5: Actualizar parámetros de facturación - Enviar facturas y notificaciones a clientes.
        CasoDeUso5.ejecutar(clienteController, habitacionController, reservaController, facturaController);

        // CASO DE USO 6: Generar un reporte del estado de las habitaciones del hotel (reservadas, disponibles).
        CasoDeUso6.ejecutar(habitacionController, reservaController);

    }
}