package Controllers;
import Modelos.Cliente;
import Modelos.Habitacion;
import Modelos.TipoContacto;
import Modelos.TipoHabitacion;

import java.util.ArrayList;
import java.util.List;

public class HabitacionController {
    private List<Habitacion> habitaciones;

    public HabitacionController() {
        habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(String idHabitacion, Integer nroHabitacion, Integer capacidad, TipoHabitacion tipoHabitacion, boolean estaHabilitada) {
        Habitacion habitacion = new Habitacion(idHabitacion, nroHabitacion, capacidad, tipoHabitacion, estaHabilitada);
        habitaciones.add(habitacion);
    }

    public void modificarHabitacion(String idHabitacion, Integer nuevonroHabitacion, Integer nuevaCapacidad,
                                    TipoHabitacion nuevoTipoHabitacion, boolean nuevaEstaHabilitada) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getIdHabitacion().equals(idHabitacion)) {
                if (nuevonroHabitacion != null) {
                    habitacion.setNroHabitacion(nuevonroHabitacion);
                }
                if (nuevaCapacidad != null) {
                    habitacion.setCapacidad(nuevaCapacidad);
                }
                if (nuevoTipoHabitacion != null) {
                    habitacion.setTipoHabitacion(nuevoTipoHabitacion);
                }
                habitacion.setEstaHabilitada(nuevaEstaHabilitada);
                break; // Se encontró el cliente, se termina el bucle
            }
        }
    }

    public void eliminarHabitacion(Habitacion habitacion) {
        habitaciones.remove(habitacion);
    }

    public Habitacion buscarHabitacionPorId(String idHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getIdHabitacion().equals(idHabitacion)) {
                return habitacion;
            }
        }
        return null; // Habitación no encontrada
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public List<Habitacion> reporteHabitaciones() {
        return habitaciones;
    }
}