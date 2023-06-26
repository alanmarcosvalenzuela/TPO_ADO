package Modelos;

public class AdapterMercadoPago implements AdapterPago{
    @Override
    public void realizarPago() {
        System.out.println("Se ha realizado el pago con Mercado Pago");
    }
}
