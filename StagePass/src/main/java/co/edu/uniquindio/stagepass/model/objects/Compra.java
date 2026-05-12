package co.edu.uniquindio.stagepass.model.objects;

import co.edu.uniquindio.stagepass.model.services.CompraState;

import java.time.LocalDateTime;
import java.util.List;

public class Compra {
    private String idCompra;
    private Usuario usuario;
    private Evento evento;
    private LocalDateTime fechaCreacion;
    private double total;
    private CompraState estado;
    private List<ItemCompra> itemsCompra;
    private List<ServicioAdicional> serviciosAdicionales;
    private List<Entrada> entradas;
    private Pago pago;

    protected Compra(){}
    private Compra(Builder builder) {
        this.idCompra = builder.idCompra;
        this.usuario = builder.usuario;
        this.evento = builder.evento;
        this.fechaCreacion = builder.fechaCreacion;
        this.total = builder.total;
        this.estado = builder.estado;
        this.itemsCompra = builder.itemsCompra;
        this.serviciosAdicionales = builder.serviciosAdicionales;
        this.entradas = builder.entradas;
        this.pago = builder.pago;
    }
    public String getIdCompra() { return idCompra; }
    public Usuario getUsuario() { return usuario; }
    public Evento getEvento() { return evento; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public double getTotal() { return total; }
    public CompraState getEstado() { return estado; }
    public List<ItemCompra> getItemsCompra() { return itemsCompra; }
    public List<ServicioAdicional> getServiciosAdicionales() { return serviciosAdicionales; }
    public List<Entrada> getEntradas() { return entradas; }
    public Pago getPago() { return pago; }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setEstado(CompraState estado) {
        this.estado = estado;
    }

    public void setItemsCompra(List<ItemCompra> itemsCompra) {
        this.itemsCompra = itemsCompra;
    }

    public void setServiciosAdicionales(List<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String idCompra;
        private Usuario usuario;
        private Evento evento;
        private LocalDateTime fechaCreacion;
        private double total;
        private CompraState estado;
        private List<ItemCompra> itemsCompra;
        private List<ServicioAdicional> serviciosAdicionales;
        private List<Entrada> entradas;
        private Pago pago;

        private Builder() {}

        public Builder idCompra(String idCompra) {
            this.idCompra = idCompra;
            return this;
        }

        public Builder usuario(Usuario usuario) {
            this.usuario = usuario;
            return this;
        }

        public Builder evento(Evento evento) {
            this.evento = evento;
            return this;
        }

        public Builder fechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }

        public Builder total(double total) {
            this.total = total;
            return this;
        }

        public Builder estado(CompraState estado) {
            this.estado = estado;
            return this;
        }

        public Builder itemsCompra(List<ItemCompra> itemsCompra) {
            this.itemsCompra = itemsCompra;
            return this;
        }

        public Builder serviciosAdicionales(List<ServicioAdicional> serviciosAdicionales) {
            this.serviciosAdicionales = serviciosAdicionales;
            return this;
        }

        public Builder entradas(List<Entrada> entradas) {
            this.entradas = entradas;
            return this;
        }

        public Builder pago(Pago pago) {
            this.pago = pago;
            return this;
        }

        public Compra build() {
            return new Compra(this);
        }
    }
    public void confirmar() {
        estado.confirmar(this);
    }
    public void cancelar() {
        estado.cancelar(this);
    }
    public String obtenerEstado() {
        return estado.getNombreEstado();
    }

}
