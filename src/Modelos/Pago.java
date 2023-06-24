package Modelos;
public class Pago {
    private String idPago;
    private double monto;
    private TipoPago metodoPago;
    private Factura factura;
    private EstadoPago estadoPago;
    private AdapterPago adapterPago;

    public Pago(String idPago, double monto, TipoPago metodoPago, Factura factura, EstadoPago estadoPago, AdapterPago adapterPago) {
        this.idPago = idPago;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.factura = factura;
        this.estadoPago = estadoPago;
        this.adapterPago = adapterPago;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public TipoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(TipoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public AdapterPago getAdapterPago() {
        return adapterPago;
    }

    public void setAdapterPago(AdapterPago adapterPago) {
        this.adapterPago = adapterPago;
    }

    public void realizarPago() {
        adapterPago.realizarPago();
    }

    public void cambiarEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getEstado() {
        return estadoPago.getEstadoPago();
    }
}
