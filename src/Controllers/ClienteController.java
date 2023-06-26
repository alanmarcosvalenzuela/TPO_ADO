package Controllers;

import Modelos.*;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> clientes;

    public ClienteController() {
        clientes = new ArrayList<>();
    }

    public void agregarCliente(String idCliente, String nombre, String apellido, String dni, TipoContacto preferenciaContacto,
                               String telefono, String email, String calle, String barrio, String provincia,
                               String codigoPostal, String pais, List reservas) {
        Cliente cliente = new Cliente(idCliente, nombre, apellido, dni, preferenciaContacto, telefono, email, calle, barrio,
                provincia, codigoPostal, pais, reservas);
        clientes.add(cliente);
    }

    public void modificarCliente(String idCliente, String nuevoNombre, String nuevoApellido,
                                 TipoContacto nuevaPreferenciaContacto, String nuevoTelefono,
                                 String nuevoEmail) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente().equals(idCliente)) {
                if (nuevoNombre != null) {
                    cliente.setNombre(nuevoNombre);
                }
                if (nuevoApellido != null) {
                    cliente.setApellido(nuevoApellido);
                }
                if (nuevaPreferenciaContacto != null) {
                    cliente.setPreferenciaContacto(nuevaPreferenciaContacto);
                }
                if (nuevoTelefono != null) {
                    cliente.setTelefono(nuevoTelefono);
                }
                if (nuevoEmail != null) {
                    cliente.setEmail(nuevoEmail);
                }
                break; // Se encontró el cliente, se termina el bucle
            }
        }
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public Cliente buscarClientePorId(String idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente().equals(idCliente)) {
                return cliente;
            }
        }
        return null; // Cliente no encontrado
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void realizarPago(Factura factura) {
        Pago instanciaPago = factura.getReserva().getPago();
        instanciaPago.realizarPago();
    }
}

