package co.edu.uniquindio.stagepass.model.objects;

import co.edu.uniquindio.stagepass.model.Enums.TipoIncidencia;
import co.edu.uniquindio.stagepass.model.GeneradorIds;

import java.time.LocalDateTime;

public class Incidencia {
    private String idIncidencia;
    private TipoIncidencia tipo;
    private String descripcion;
    private LocalDateTime fechaRegistro;
    private String idEvento;
    private String idCompra;

    public Incidencia(TipoIncidencia tipo, String descripcion, String idEvento, String idCompra) {
        this.idIncidencia = GeneradorIds.generarIdIncidencia();
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaRegistro = LocalDateTime.now();
        this.idEvento = idEvento;
        this.idCompra = idCompra;
    }

    public String getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(String idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public TipoIncidencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoIncidencia tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }
}
