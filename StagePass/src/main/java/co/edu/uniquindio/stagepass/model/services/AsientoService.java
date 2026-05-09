package co.edu.uniquindio.stagepass.model.services;

import co.edu.uniquindio.stagepass.model.objects.Asiento;

import java.util.List;

public interface AsientoService {
    //Requisitos RF-031
    public void agregarAsiento(String idZona, Asiento asiento);
    public void actualizarAsiento(String idZona, Asiento asiento);
    public void eliminarAsiento(String idZona, String idAsiento);

    //Requisitos RF-032
    public void cambiarEstado(String idZona, String idAsiento, EstadoAsiento estado);

    //Requisito RF-033
    public List<Asiento> consultarMapaAsientos(String idZona);
}
