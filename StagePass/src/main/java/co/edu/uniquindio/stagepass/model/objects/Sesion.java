package co.edu.uniquindio.stagepass.model.objects;

import java.time.LocalDateTime;

public class Sesion {
    private Usuario usuarioActual;
    private boolean activa;
    private LocalDateTime fechaInicio;

    public Sesion(Usuario usuarioActual, boolean activa, LocalDateTime fechaInicio) {
        this.usuarioActual = usuarioActual;
        this.activa = activa;
        this.fechaInicio = fechaInicio;
    }

    public boolean estaActiva(){
        return activa;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
