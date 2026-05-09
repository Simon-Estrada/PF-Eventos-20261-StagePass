package co.edu.uniquindio.stagepass.model.services;

import co.edu.uniquindio.stagepass.model.objects.Asiento;
import co.edu.uniquindio.stagepass.model.objects.Evento;
import co.edu.uniquindio.stagepass.model.objects.Recinto;
import co.edu.uniquindio.stagepass.model.objects.Zona;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EventoService {
    //Requisitos RF-023
    public Evento crearEvento(Evento evento);
    public void actualizarEvento(Evento evento);
    public void eliminarEvento(String idEvento);
    public List<Evento> consultarEventos();
    public Evento buscarPorId(String idEvento);

    //Requisitos RF-024
    public void publicarEvento(String idEvento);
    public void pausarEvento(String idEvento);
    public void cancelarEvento(String idEvento);
    public void finalizarEvento(String idEvento);

    //Para asociar recinto a Evento
    public void asignarRecinto(String idEvento, Recinto recinto);
    public Recinto obtenerRecinto(String idEvento);
    public void actualizarRecinto(String idEvento, Recinto recinto);

    //Requisitos RF-025
    public Map<Zona, Integer> consultarDisponibilidad(String idEvento);
    public List<Asiento> consultarAsientosDisponibles(String idEvento, String idZona);

    //filtros
    public List<Evento> filtrarPorCiudad(String ciudad);
    public List<Evento> filtrarPorCategoria(Categoria categoria);
    public List<Evento> filtrarPorFecha(LocalDate fecha);
    public List<Evento> filtrarPorPrecio(double min, double max);

}
