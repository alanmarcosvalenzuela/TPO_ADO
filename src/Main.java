import Controllers.ClienteController;
import Modelos.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // CASO DE USO 1: Cargar nuevos clientes

        // Instancia de ClienteController
        ClienteController clienteController = new ClienteController();

        // Cliente 1
        clienteController.agregarCliente("1", "Jorge", "Ramírez", "37989047", TipoContacto.WHATSAPP,
                "1563687954", "jramirez@gmail.com", "Av. Rivadavia 147", "",
                "Buenos Aires", "111", "Argentina", new ArrayList<>());

        // Cliente 2
        clienteController.agregarCliente("2", "Luciana", "Pérez", "38975461", TipoContacto.SMS,
                "1568787411", "lperez@gmail.com", "Av. Independencia 289", "Constitución",
                "Buenos Aires", "123", "Argentina", new ArrayList<>());

        // Cliente 3
        clienteController.agregarCliente("3", "Mario", "Gutierrez", "25897879", TipoContacto.MAIL,
                "1234567890", "mgutierrez@gmail.com", "San Martín 268", "Barrio Centro",
                "Santa Fe", "222", "Argentina", new ArrayList<>());

        // Cliente 4
        clienteController.agregarCliente("4", "Natalia", "López", "25787879", TipoContacto.SMS,
                "1568987447", "nlopez@gmail.com", "Lavalle 101", "Microcentro",
                "Buenos Aires", "134", "Argentina", new ArrayList<>());

        // Modifico cliente de encontrar id
        clienteController.modificarCliente("1", "Jaime", null, null, "42479874", null);

        // Busco instancia cliente por id para eliminar
        Cliente clienteEliminar = clienteController.buscarClientePorId("3");
        clienteController.eliminarCliente(clienteEliminar);

        // Imprimir lista de clientes
        List<Cliente> clientes = clienteController.getClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getIdCliente() + ": " + cliente.getNombre() + " " + cliente.getApellido());
        }
    }
}