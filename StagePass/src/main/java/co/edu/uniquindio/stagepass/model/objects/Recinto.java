package co.edu.uniquindio.stagepass.model.objects;

import co.edu.uniquindio.stagepass.model.GeneradorIds;

import java.util.List;

public class Recinto {
    private String idRecinto;
    private String nombre;
    private String direccion;
    private String ciudad;
    private List<Zona> zonas;

    public Recinto(String nombre, String direccion, String ciudad) {
        this.idRecinto = GeneradorIds.generarIdRecinto();
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.zonas = new java.util.ArrayList<>();
    }

    public String getIdRecinto() {
        return idRecinto;
    }

    public void setIdRecinto(String idRecinto) {
        this.idRecinto = idRecinto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }

}
