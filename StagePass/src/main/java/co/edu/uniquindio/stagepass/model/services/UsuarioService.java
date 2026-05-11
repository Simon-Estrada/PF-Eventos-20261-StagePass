package co.edu.uniquindio.stagepass.model.services;

import co.edu.uniquindio.stagepass.model.Enums.Rol;
import co.edu.uniquindio.stagepass.model.MetodoPagoUsuario;
import co.edu.uniquindio.stagepass.model.objects.Usuario;

import java.util.List;

public interface UsuarioService {
    //RF-020
    public Usuario registrarUsuario(String nombre, String correo, String telefono, String contrasena, Rol rol);
    public void actualizarPerfil(Usuario usuario);
    public Usuario obtenerUsuario(String idUsuario);
    public List<Usuario> listarUsuarios();
    public void eliminarUsuario(String idUsuario);

    //RF-021
    public void agregarMetodoPago(String idUsuario,MetodoPagoUsuario metodoPago);
    public void eliminarMetodoPago(String idUsuario, String idMetodoPago);
    List<MetodoPagoUsuario> obtenerMetodosPago(String idUsuario);

    //RF-022
    public List<Compra> obtenerComprasUsuario(String idUsuario);


}
