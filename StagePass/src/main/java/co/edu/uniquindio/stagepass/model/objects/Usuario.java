package co.edu.uniquindio.stagepass.model.objects;

import co.edu.uniquindio.stagepass.model.Enums.Rol;
import co.edu.uniquindio.stagepass.model.GeneradorIds;
import co.edu.uniquindio.stagepass.model.MetodoPagoUsuario;

import java.util.List;

public class Usuario {

    private String idUsuario;
    private String nombre;
    private String correo;
    private String telefono;
    private String contrasena;
    private Rol rol;

    private List<MetodoPagoUsuario> metodosPago;
    private List<Compra> compras;

    public Usuario(String correo, String nombre, String telefono, String contrasena, Rol rol, List<MetodoPagoUsuario> metodosPago, List<Compra> compras) {
        this.idUsuario = GeneradorIds.generarIdUsuario();
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.rol = rol;
        this.metodosPago = metodosPago;
        this.compras = compras;
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

    public List<MetodoPagoUsuario> getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(List<MetodoPagoUsuario> metodosPago) {
        this.metodosPago = metodosPago;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario='" + idUsuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", rol=" + rol +
                '}';
    }
}