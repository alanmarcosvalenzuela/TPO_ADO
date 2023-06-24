package Controllers;

import Modelos.Hotel;
import Modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class HotelController {
    private List<Hotel> hoteles;
    private List<Usuario> usuarios;

    public HotelController() {
        hoteles =  new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void agregarHotel(Hotel hotel) {
        hoteles.add(hotel);
    }

    public void eliminarHotel(Hotel hotel) {
        hoteles.remove(hotel);
    }

    public void modificarHotel(Hotel hotel, String nuevoNombre, String nuevaDireccion, String nuevoTelefono, String nuevoEmail) {
        hotel.setNombre(nuevoNombre);
        hotel.setDireccion(nuevaDireccion);
        hotel.setTelefono(nuevoTelefono);
        hotel.setEmail(nuevoEmail);
    }

    public List<Hotel> getHoteles() {
        return hoteles;
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public void modificarUsuario(Usuario usuario, String nuevoNombre, String nuevoApellido, String nuevoMail) {
        usuario.nombre = nuevoNombre;
        usuario.apellido = nuevoApellido;
        usuario.mail = nuevoMail;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }


}
