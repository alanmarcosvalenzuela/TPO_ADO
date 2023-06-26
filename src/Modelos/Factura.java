package Modelos;

import java.time.LocalDate;
import java.util.List;

public class Factura {
    private String idFactura;
    private LocalDate fechaEmision;
    private double monto;
    private Cliente cliente;

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    private Reserva reserva;
    private String descripcion;
    private List<Promocion> promociones;

    public Factura(String idFactura, LocalDate fechaEmision, Cliente cliente, Reserva reserva, String descripcion, List<Promocion> promociones) {
        this.idFactura = idFactura;
        this.fechaEmision = fechaEmision;
        this.cliente = cliente;
        this.reserva = reserva;
        this.descripcion = descripcion;
        this.promociones = promociones;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion> promociones) {
        this.promociones = promociones;
    }

    public Float implementarPromocion(Promocion promocion) {
        // Ejemplo de cálculo de descuento:
        Float monto = 0.0f;/* Obtener el monto de la factura */
        Float descuento = 0.0f; /* Calcular el descuento basado en la promoción */
        Float montoConDescuento = monto - descuento;

        return montoConDescuento;
    }
}
