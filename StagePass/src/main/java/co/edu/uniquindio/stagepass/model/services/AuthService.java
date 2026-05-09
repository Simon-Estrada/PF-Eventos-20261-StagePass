package co.edu.uniquindio.stagepass.model.services;

import co.edu.uniquindio.stagepass.model.objects.Sesion;
import co.edu.uniquindio.stagepass.model.objects.Usuario;

public interface AuthService {
    public Usuario login(String correo, String contrasena);
    public Usuario registrar(String nombre, String correo, String telefono, String contrasenaHash);
    public void logout();
    public Sesion obtenerSesionActual();
    public boolean haySesionActiva();
}
