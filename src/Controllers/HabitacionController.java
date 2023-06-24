package Controllers;
import Modelos.Habitacion;
import Modelos.TipoHabitacion;

import java.util.ArrayList;
import java.util.List;

public class HabitacionController {
    private List<Habitacion> habitaciones;

    public HabitacionController() {
        habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(String idHabitacion, Integer nroHabitacion, Integer capacidad, TipoHabitacion tipoHabitacion) {
        Habitacion habitacion = new Habitacion(idHabitacion, nroHabitacion, capacidad, tipoHabitacion);
        habitaciones.add(habitacion);
    }

    public void eliminarHabitacion(Habitacion habitacion) {
        habitaciones.remove(habitacion);
    }

    public void modificarHabitacion(Habitacion habitacion, String nuevoIdHabitacion, Integer nuevonroHabitacion, Integer nuevaCapacidad, TipoHabitacion nuevoTipoHabitacion) {
        habitacion.setIdHabitacion(nuevoIdHabitacion);
        habitacion.setNroHabitacion(nuevonroHabitacion);
        habitacion.setCapacidad(nuevaCapacidad);
        habitacion.setTipoHabitacion(nuevoTipoHabitacion);
    }

    public List<Habitacion> reporteHabitaciones() {
        return habitaciones;
    }
}