package co.edu.uniquindio.stagepass.model;

import co.edu.uniquindio.stagepass.model.Enums.TipoMetodoPago;

public class MetodoPagoUsuario {
    private String id;
    private TipoMetodoPago tipoMetodoPago;
    private String numeroReferencia;
    private double saldo;
    private boolean activo;

    public MetodoPagoUsuario(String id, TipoMetodoPago tipoMetodoPago, String numeroReferencia, double saldo, boolean activo) {
        this.id = id;
        this.tipoMetodoPago = tipoMetodoPago;
        this.numeroReferencia = numeroReferencia;
        this.saldo = saldo;
        this.activo = activo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoMetodoPago getTipoMetodoPago() {
        return tipoMetodoPago;
    }

    public void setTipoMetodoPago(TipoMetodoPago tipoMetodoPago) {
        this.tipoMetodoPago = tipoMetodoPago;
    }

    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldoPuntos) {
        this.saldo = saldoPuntos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
