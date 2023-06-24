package Controllers;

import Modelos.Cliente;
import Modelos.Factura;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> clientes;

    public ClienteController() {
        clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
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
        // Implementar lógica para realizar el pago de la factura
        // Puedes utilizar los datos de la factura y del cliente para realizar las acciones necesarias
    }
}

