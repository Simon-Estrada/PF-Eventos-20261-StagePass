package co.edu.uniquindio.stagepass.model.objects;

import co.edu.uniquindio.stagepass.model.Enums.EstadoEntrada;

public class Entrada {
    private String idEntrada;
    private Evento evento;
    private Zona zona;
    private Asiento asiento;
    private Compra compra;
    private double precioFinal;
    private EstadoEntrada estadoEntrada;

    public Entrada(String idEntrada, Evento evento, Zona zona, Asiento asiento, Compra compra, double precioFinal, EstadoEntrada estadoEntrada) {
        this.idEntrada = idEntrada;
        this.evento = evento;
        this.zona = zona;
        this.asiento = asiento;
        this.compra = compra;
        this.precioFinal = precioFinal;
        this.estadoEntrada = estadoEntrada;
    }

    public String getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(String idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public EstadoEntrada getEstadoEntrada() {
        return estadoEntrada;
    }

    public void setEstadoEntrada(EstadoEntrada estadoEntrada) {
        this.estadoEntrada = estadoEntrada;
    }
}
