import Controllers.ClienteController;
import Modelos.Cliente;
import Modelos.TipoContacto;
import java.util.List;

public class CasoDeUso1 {
    public static void ejecutar(ClienteController clienteController) {
        // Código correspondiente al Caso de Uso 1
        System.out.println();
        System.out.println("-------------- CASO DE USO 1 : CARGAR NUEVOS CLIENTES --------------");

        // Carga de Clientes

        // Cliente 1
        clienteController.agregarCliente("1", "Jorge", "Ramírez", "37989047", TipoContacto.WHATSAPP,
                "1563687954", "jramirez@gmail.com", "Av. Rivadavia 147", "",
                "Buenos Aires", "111", "Argentina");

        // Cliente 2
        clienteController.agregarCliente("2", "Luciana", "Pérez", "38975461", TipoContacto.SMS,
                "1568787411", "lperez@gmail.com", "Av. Independencia 289", "Constitución",
                "Buenos Aires", "123", "Argentina");

        // Cliente 3
        clienteController.agregarCliente("3", "Mario", "Gutierrez", "25897879", TipoContacto.MAIL,
                "1234567890", "mgutierrez@gmail.com", "San Martín 268", "Barrio Centro",
                "Santa Fe", "222", "Argentina");

        // Cliente 4
        clienteController.agregarCliente("4", "Natalia", "López", "25787879", TipoContacto.SMS,
                "1568987447", "nlopez@gmail.com", "Lavalle 101", "Microcentro",
                "Buenos Aires", "134", "Argentina");

        // Cliente 5
        clienteController.agregarCliente("5", "Carlos", "Martínez", "36547896", TipoContacto.WHATSAPP,
                "1569874562", "cmartinez@gmail.com", "Calle 123", "Barrio Norte",
                "Buenos Aires", "567", "Argentina");

        // Cliente 6
        clienteController.agregarCliente("6", "María", "González", "38965412", TipoContacto.MAIL,
                "1234567890", "mgonzalez@gmail.com", "Av. Libertador 789", "",
                "Buenos Aires", "890", "Argentina");

        // Cliente 7
        clienteController.agregarCliente("7", "Pedro", "Fernández", "47859623", TipoContacto.WHATSAPP,
                "1567854321", "pfernandez@gmail.com", "Calle 456", "Barrio Sur",
                "Córdoba", "456", "Argentina");


        // Modificar cliente
        clienteController.modificarCliente("1", "Jaime", null, null, "42479874", null);

        // Buscar instancia determinada
        Cliente clienteEliminar = clienteController.buscarClientePorId("3");

        // Eliminar la instancia de cliente buscada
        clienteController.eliminarCliente(clienteEliminar);


        // Imprimir lista de clientes actualizada
        List<Cliente> clientes = clienteController.getClientes();

        System.out.println("Lista de Clientes: ");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getIdCliente() + ": " + cliente.getNombre() + " " + cliente.getApellido() + ", teléfono: " + cliente.getTelefono() + ", email: " + cliente.getEmail());
        }

    }
}
