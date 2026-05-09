package co.edu.uniquindio.stagepass.model.services;

import co.edu.uniquindio.stagepass.model.objects.Recinto;
import co.edu.uniquindio.stagepass.model.objects.Zona;

import java.util.List;


public interface RecintoService {
    //Requisitos RF-026
    public Recinto crearRecinto(Recinto recinto);
    public void actualizarRecinto(Recinto recinto);
    public void eliminarRecinto(String idRecinto);
    public List<Recinto> consultarRecintos();
    public Recinto buscarPorId(String idRecinto);

    //Requisitos RF-027
    public void asignarZona(String idRecinto, Zona zona);
    public void removerZona(String idRecinto, Zona zona);

}
