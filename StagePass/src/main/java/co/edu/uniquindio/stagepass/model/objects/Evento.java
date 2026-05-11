package co.edu.uniquindio.stagepass.model.objects;


import co.edu.uniquindio.stagepass.model.Enums.Categoria;
import co.edu.uniquindio.stagepass.model.Enums.EstadoEvento;
import co.edu.uniquindio.stagepass.model.GeneradorIds;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private String idEvento;
    private String nombre;
    private Categoria categoria;
    private String descripcion;
    private String ciudad;
    private LocalDate fecha;
    private LocalTime hora;
    private EstadoEvento estadoEvento;
    private PoliticaCancelacion politicaCancelacion;
    private PoliticaReembolso politicaReembolso;
    private Recinto recinto;

    public Evento(String nombre, Categoria categoria, String ciudad, String descripcion, LocalDate fecha, LocalTime hora) {
        this.idEvento = GeneradorIds.generarIdEvento();
        this.nombre = nombre;
        this.categoria = categoria;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public PoliticaCancelacion getPoliticaCancelacion() {
        return politicaCancelacion;
    }

    public void setPoliticaCancelacion(PoliticaCancelacion politicaCancelacion) {
        this.politicaCancelacion = politicaCancelacion;
    }

    public EstadoEvento getEstado() {
        return estadoEvento;
    }

    public void setEstado(EstadoEvento estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    public PoliticaReembolso getPoliticaReembolso() {
        return politicaReembolso;
    }

    public void setPoliticaReembolso(PoliticaReembolso politicaReembolso) {
        this.politicaReembolso = politicaReembolso;
    }

    public Recinto getRecinto() {
        return recinto;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }
}
