package co.edu.uniquindio.stagepass.model;

import co.edu.uniquindio.stagepass.model.objects.Asiento;
import co.edu.uniquindio.stagepass.model.objects.Evento;
import co.edu.uniquindio.stagepass.model.objects.Recinto;
import co.edu.uniquindio.stagepass.model.objects.Zona;
import co.edu.uniquindio.stagepass.model.services.EventoService;

import java.security.cert.CertPathBuilderException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventoServiceImp implements EventoService {
    private EventoRepository eventoRepository;
    private IncidenciaService incidenciaService;
    @Override
    public Evento crearEvento(Evento evento) {

        if(evento == null){
            throw new IllegalArgumentException("El evento es nulo");
        }
        validarDatos(evento);
        if(evento.getFecha().isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("La fecha ingresada no puede ser anterior a la fecha actual");
        }
        evento.setEstado(EstadoEvento.BORRADOR);
        eventoRepository.guardar(evento);

        return evento;
    }

    @Override
    public void actualizarEvento(Evento evento) {
        validarDatos(evento);
        Evento existente = buscarPorId(evento.getIdEvento());
        if(existente.getEstado()==EstadoEvento.FINALIZADO){
            throw new IllegalArgumentException("El evento ya finalizo, por lo tanto no puede ser modificado.");
        }
        eventoRepository.actualizar(evento);

    }

    @Override
    public void eliminarEvento(String idEvento) {
        Evento evento = buscarPorId(idEvento);
        if(evento.getEstado()== EstadoEvento.PUBLICADO){
            throw new IllegalArgumentException("No se puede eliminar un evento publicado.");
        }
        eventoRepository.eliminar(idEvento);
    }

    @Override
    public List<Evento> consultarEventos() {
        return eventoRepository.obtenerTodo();
    }

    @Override
    public Evento buscarPorId(String idEvento) {
        Evento evento = eventoRepository.buscarPorId(idEvento);
        if(evento==null){
            throw new IllegalArgumentException("El evento no existe.");
        }
        return evento;
    }

    @Override
    public void publicarEvento(String idEvento) {
        Evento evento = buscarPorId(idEvento);
        if(evento.getRecinto()== null){
            throw new IllegalArgumentException("El evento no tiene recinto asignado.");
        }
        if(evento.getEstado()!= EstadoEvento.BORRADOR){
            throw new IllegalArgumentException("Solo puede publicar un evento en borrador.");
        }
        evento.setEstado(EstadoEvento.PUBLICADO);
        eventoRepository.actualizar(evento);

    }

    @Override
    public void pausarEvento(String idEvento) {
        Evento evento= buscarPorId(idEvento);
        if(evento.getEstado()!= EstadoEvento.PUBLICADO){
            throw new IllegalArgumentException("Solo eventos publicados pueden ser pausados."):
        }
        evento.setEstado(EstadoEvento.PAUSADO);
        eventoRepository.actualizar(evento);

    }

    @Override
    public void cancelarEvento(String idEvento) {
        Evento evento= buscarPorId(idEvento);
        if(evento.getEstado()==EstadoEvento.FINALIZADO){
            throw new IllegalArgumentException("No se puede cancelar este evento, ya finalizo");
        }
        evento.setEstado(EstadoEvento.CANCELADO);
        incidenciaService.registrarIncidencia(new Incidencia());
        eventoRepository.actualizar(evento);

    }

    @Override
    public void finalizarEvento(String idEvento) {
        Evento evento = buscarPorId(idEvento);

        if(evento.getEstado() != EstadoEvento.PUBLICADO){
            throw new IllegalArgumentException("Solo eventos publicados pueden finalizarse.");
        }

        evento.setEstado(EstadoEvento.FINALIZADO);

        eventoRepository.actualizar(evento);

    }

    @Override
    public void asignarRecinto(String idEvento, Recinto recinto) {
        Evento evento = buscarPorId(idEvento);

        if(recinto == null){
            throw new IllegalArgumentException("El recinto es nulo.");
        }

        evento.setRecinto(recinto);

        eventoRepository.actualizar(evento);

    }

    @Override
    public Recinto obtenerRecinto(String idEvento) {
        Evento evento = buscarPorId(idEvento);

        return evento.getRecinto();
    }

    @Override
    public void actualizarRecinto(String idEvento, Recinto recinto) {
        Evento evento = buscarPorId(idEvento);

        evento.setRecinto(recinto);

        eventoRepository.actualizar(evento);

    }

    @Override
    public Map<Zona, Integer> consultarDisponibilidad(String idEvento) {
        return Map.of();
    }

    @Override
    public List<Asiento> consultarAsientosDisponibles(String idEvento, String idZona) {
        Evento evento = buscarPorId(idEvento);

        for(Zona zona : evento.getRecinto().getZonas()){

            if(zona.getIdZona().equals(idZona)){

                return zona.getAsientos()
                        .stream()
                        .filter(a -> a.getEstado() == EstadoAsiento.DISPONIBLE)
                        .toList();
            }
        }

        return new ArrayList<>();
    }

    @Override
    public List<Evento> filtrarPorCiudad(String ciudad) {
        return eventoRepository.filtrarPorCiudad(ciudad);
    }

    @Override
    public List<Evento> filtrarPorCategoria(Categoria categoria) {
        return eventoRepository.filtrarPorCategoria(categoria);
    }

    @Override
    public List<Evento> filtrarPorFecha(LocalDate fecha) {
        return eventoRepository.filtrarPorFecha(fecha);
    }

    @Override
    public List<Evento> filtrarPorPrecio(double min, double max) {
        return eventoRepository.filtrarPorPrecio(min, max);
    }
    private void validarDatos(Evento evento){
        if(evento.getNombre() == null
                || evento.getNombre().isBlank()
                || evento.getCiudad() == null
                || evento.getCiudad().isBlank()
                || evento.getDescripcion() == null
                || evento.getDescripcion().isBlank()
                || evento.getFecha() == null
                || evento.getCategoria() == null){
            throw new IllegalArgumentException("El evento tiene campos obligatorios vacios.");
        }
    }
}
