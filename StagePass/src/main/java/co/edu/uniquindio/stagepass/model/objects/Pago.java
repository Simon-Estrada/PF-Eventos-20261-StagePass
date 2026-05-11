package co.edu.uniquindio.stagepass.model.objects;

import co.edu.uniquindio.stagepass.model.Enums.EstadoPago;

import co.edu.uniquindio.stagepass.model.MetodoPagoUsuario;


import java.time.LocalDateTime;

public class Pago {
    private String idPago;
    private Compra compra;
    private double monto;
    private LocalDateTime fecha;
    private EstadoPago estadoPago;
    private MetodoPagoUsuario metodoPagoUsuario;

    public Pago(String idPago, Compra compra, double monto, LocalDateTime fecha, EstadoPago estadoPago, MetodoPagoUsuario metodoPagoUsuario) {
        this.idPago = idPago;
        this.compra = compra;
        this.monto = monto;
        this.fecha = fecha;
        this.estadoPago = estadoPago;
        this.metodoPagoUsuario = metodoPagoUsuario;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public MetodoPagoUsuario getMetodoPagoUsuario() {
        return metodoPagoUsuario;
    }

    public void setMetodoPagoUsuario(MetodoPagoUsuario metodoPagoUsuario) {
        this.metodoPagoUsuario = metodoPagoUsuario;
    }
}
