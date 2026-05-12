package co.edu.uniquindio.stagepass.model;

import co.edu.uniquindio.stagepass.model.Enums.Categoria;
import co.edu.uniquindio.stagepass.model.Enums.Rol;
import co.edu.uniquindio.stagepass.model.objects.*;
import co.edu.uniquindio.stagepass.model.services.EventoService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class EventoServiceProxy implements EventoService {
    private EventoService real;
    private Sesion sesion;

    public EventoServiceProxy(EventoService real, Sesion sesion) {
        this.real = real;
        this.sesion = sesion;
    }

    private void validarAdmin(){
        if(sesion==null||!sesion.estaActiva()){
            throw new RuntimeException("La sesion no esta activa.");
        }
        if(sesion.getUsuarioActual().getRol()!= Rol.ADMIN){
            throw new RuntimeException("Acceso denegado");
        }
    }
    private void validarSesion() {

        if (sesion == null || !sesion.estaActiva()) {
            throw new RuntimeException("Debe iniciar sesión");
        }
    }

    @Override
    public Evento crearEvento(Evento evento) {
        validarAdmin();
        return real.crearEvento(evento);
    }

    @Override
    public void actualizarEvento(Evento evento) {
        validarAdmin();
        real.actualizarEvento(evento);
    }

    @Override
    public void eliminarEvento(String idEvento) {
        validarAdmin();
        real.eliminarEvento(idEvento);
    }

    @Override
    public List<Evento> consultarEventos() {
       validarSesion();
       return real.consultarEventos();
    }

    @Override
    public Evento buscarPorId(String idEvento) {
        validarSesion();
        return real.buscarPorId(idEvento);
    }

    @Override
    public void publicarEvento(String idEvento) {
        validarAdmin();
        real.publicarEvento(idEvento);
    }

    @Override
    public void pausarEvento(String idEvento) {
        validarAdmin();
        real.pausarEvento(idEvento);
    }

    @Override
    public void cancelarEvento(String idEvento) {
        validarAdmin();
        real.cancelarEvento(idEvento);
    }

    @Override
    public void finalizarEvento(String idEvento) {
        validarAdmin();
        real.finalizarEvento(idEvento);
    }

    @Override
    public void asignarRecinto(String idEvento, Recinto recinto) {
        validarAdmin();
        real.asignarRecinto(idEvento, recinto);
    }

    @Override
    public Recinto obtenerRecinto(String idEvento) {
        validarSesion();
        return real.obtenerRecinto(idEvento);
    }

    @Override
    public void actualizarRecinto(String idEvento, Recinto recinto) {
        validarAdmin();
        real.actualizarRecinto(idEvento, recinto);
    }

    @Override
    public Map<Zona, Integer> consultarDisponibilidad(String idEvento) {
        validarSesion();
        return real.consultarDisponibilidad(idEvento);
    }

    @Override
    public List<Asiento> consultarAsientosDisponibles(String idEvento, String idZona) {
        validarSesion();
        return real.consultarAsientosDisponibles(idEvento, idZona);
    }

    @Override
    public List<Evento> filtrarPorCiudad(String ciudad) {
        validarSesion();
        return real.filtrarPorCiudad(ciudad);
    }

    @Override
    public List<Evento> filtrarPorCategoria(Categoria categoria) {
        validarSesion();
        return real.filtrarPorCategoria(categoria);
    }

    @Override
    public List<Evento> filtrarPorFecha(LocalDate fecha) {
        validarSesion();
        return real.filtrarPorFecha(fecha);
    }

    @Override
    public List<Evento> filtrarPorPrecio(double min, double max) {
        validarSesion();
        return real.filtrarPorPrecio(min, max);
    }
}
