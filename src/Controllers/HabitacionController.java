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

    public void reporteHabitaciones() {

        List<Habitacion> habitaciones = this.getHabitaciones();

        System.out.println("-------- REPORTE DE HABITACIONES --------");

        for (Habitacion habitacion : habitaciones){
            System.out.println("ID Habitación: " + habitacion.getIdHabitacion());
            System.out.println("Nro Habitación: " + habitacion.getNroHabitacion());
            System.out.println("Tipo :" + habitacion.getTipoHabitacion().getDescripcion());
            System.out.println("Capacidad: " + habitacion.getCapacidad());
            if (habitacion.isEstaHabilitada()) {
                System.out.println("DISPONIBLE");
            } else {
                System.out.println("NO DISPONIBLE");
            }
            System.out.println();
        }
    }

    public List<Habitacion> getTodasLasHabitacionesConFiltro(TipoHabitacion tipoHabitacion, Integer capacidad, Float precio, Boolean disponibilidad) {
        List<Habitacion> habitacionesFiltradas = new ArrayList<>();

        for (Habitacion habitacion : habitaciones) {
            if (cumpleConFiltro(habitacion, tipoHabitacion, capacidad, precio, disponibilidad)) {
                habitacionesFiltradas.add(habitacion);
            }
        }

        return habitacionesFiltradas;
    }

    private boolean cumpleConFiltro(Habitacion habitacion, TipoHabitacion tipoHabitacion, Integer capacidad, Float precio, Boolean disponibilidad) {
        // Verificar cada criterio de filtrado

        if (tipoHabitacion != null && habitacion.getTipoHabitacion() != tipoHabitacion) {
            return false;
        }

        if (capacidad != null && habitacion.getCapacidad() < capacidad) {
            return false;
        }

        if (precio != null && habitacion.getPrecioHabitacion() < precio) {
            return false;
        }

        if (disponibilidad != null && habitacion.isEstaHabilitada() != disponibilidad) {
            return false;
        }

        return true;
    }
}