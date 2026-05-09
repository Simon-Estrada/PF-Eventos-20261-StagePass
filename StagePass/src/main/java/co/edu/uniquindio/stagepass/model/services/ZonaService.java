package co.edu.uniquindio.stagepass.model.services;

import co.edu.uniquindio.stagepass.model.objects.Asiento;
import co.edu.uniquindio.stagepass.model.objects.Zona;

import java.util.List;


public interface ZonaService {
    //Requisitos RF-028
    public Zona crearZona(Zona zona);
    public void actualizarZona(Zona zona);
    public void eliminarZona(String idZona);
    public List<Zona> consultarZonas();
    public Zona buscarPorId(String idZona);

    //Requisitos RF-029
    public void definirPrecioBase(String idZona, double precio);
    public void definirCapacidad(String idZona, int capacidad);

    //Requisito RF-030
    public double consultarOcupacion(String idZona);

}
