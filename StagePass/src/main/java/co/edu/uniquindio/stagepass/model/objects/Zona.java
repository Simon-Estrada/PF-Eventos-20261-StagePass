package co.edu.uniquindio.stagepass.model.objects;

import co.edu.uniquindio.stagepass.model.GeneradorIds;

import java.util.ArrayList;
import java.util.List;

public class Zona {
    private String idZona;
    private String nombre;
    private int capacidad;
    private double precioBase;
    private List<Asiento> asientos;

    public Zona(List<Asiento> asientos, double precioBase, int capacidad, String nombre) {
        this.idZona = GeneradorIds.generarIdZona();
        this.asientos = (asientos != null) ? asientos : new ArrayList<>();
        this.precioBase = precioBase;
        this.capacidad = capacidad;
        this.nombre = nombre;
    }

    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }
}
