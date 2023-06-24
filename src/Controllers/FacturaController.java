package Controllers;

import Modelos.Cliente;
import Modelos.Factura;
import Modelos.Promocion;

import java.util.ArrayList;
import java.util.List;
public class FacturaController {
    private List<Factura> facturas;

    public FacturaController() {
        facturas = new ArrayList<>();
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public void eliminarFactura(Factura factura) {
        facturas.remove(factura);
    }

    public void modificarFactura(Factura facturaExistente, Factura facturaModificada) {
        int index = facturas.indexOf(facturaExistente);
        if (index != -1) {
            facturas.set(index, facturaModificada);
        }
    }

    public void enviarFactura(Cliente cliente, Factura factura) {
        System.out.println("Enviando factura al cliente " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Factura ID: " + factura.getIdFactura());
    }

    public void modificarPromocion(Promocion promocion, Factura factura) {
        System.out.println("Modificando promoción de la factura " + factura.getIdFactura());
    }

    // Otros métodos y funcionalidades del controlador

    public List<Factura> getFacturas() {
        return facturas;
    }
}
