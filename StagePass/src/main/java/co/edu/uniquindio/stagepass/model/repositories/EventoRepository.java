package co.edu.uniquindio.stagepass.model.repositories;

import co.edu.uniquindio.stagepass.model.objects.Evento;
import co.edu.uniquindio.stagepass.model.Enums.Categoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventoRepository {
    private Map<String, Evento> datos;

    public EventoRepository() {
        datos = new HashMap<>();
    }

    public Evento guardar(Evento evento) {
        datos.put(evento.getIdEvento(), evento);
        return evento;
    }

    public Evento buscarPorId(String idEvento) {
        return datos.get(idEvento);
    }

    public void actualizar(Evento evento) {
        if (!datos.containsKey(evento.getIdEvento())) {
            throw new IllegalArgumentException("el evento no existe.");
        }
        datos.put(evento.getIdEvento(), evento);

    }

    public void eliminar(String idEvento) {
        if (!datos.containsKey(idEvento)) {
            throw new IllegalArgumentException("El evento no existe.");
        }

        datos.remove(idEvento);
    }

    public List<Evento> obtenerTodo() {
        return new ArrayList<>(datos.values());
    }

    public List<Evento> filtrarPorFecha(LocalDate fecha) {
        List<Evento> eventosFiltrados = new ArrayList<>();

        for (Evento evento : datos.values()) {

            if (evento.getFecha().equals(fecha)) {

                eventosFiltrados.add(evento);
            }
        }

        return eventosFiltrados;

    }

    public List<Evento> filtrarPorCiudad(String ciudad) {
        List<Evento> eventosFiltrados = new ArrayList<>();

        for (Evento evento : datos.values()) {

            if (evento.getRecinto().getCiudad().equals(ciudad)) {

                eventosFiltrados.add(evento);
            }
        }

        return eventosFiltrados;

    }

    public List<Evento> filtrarPorCategoria(Categoria categoria) {
        List<Evento> eventosFiltrados = new ArrayList<>();

        for (Evento evento : datos.values()) {

            if (evento.getCategoria().equals(categoria)) {

                eventosFiltrados.add(evento);
            }
        }

        return eventosFiltrados;

    }

}
