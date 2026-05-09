package co.edu.uniquindio.stagepass.model.objects;

import co.edu.uniquindio.stagepass.model.Enums.Rol;

public class Usuario {
    private String idUsuario;
    private String nombre;
    private String correo;
    private String telefono;
    private String contrasena;
    private Rol rol;
    private List<MetodosPagoUsuario> metodosPago;
    private List<Pago> historialPagos;

    public Usuario(String idUsuario, String correo, String nombre, String telefono, String contrasena, Rol rol, List<MetodosPagoUsuario> metodosPago, List<Pago> historialPagos) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.rol = rol;
        this.metodosPago = metodosPago;
        this.historialPagos = historialPagos;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<MetodosPagoUsuario> getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(List<MetodosPagoUsuario> metodosPago) {
        this.metodosPago = metodosPago;
    }

    public List<Pago> getHistorialPagos() {
        return historialPagos;
    }

    public void setHistorialPagos(List<Pago> historialPagos) {
        this.historialPagos = historialPagos;
    }
}
