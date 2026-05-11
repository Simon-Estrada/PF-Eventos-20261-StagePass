package co.edu.uniquindio.stagepass.model.servicesimp;

import co.edu.uniquindio.stagepass.model.objects.Sesion;
import co.edu.uniquindio.stagepass.model.objects.Usuario;
import co.edu.uniquindio.stagepass.model.repositories.UsuarioRepository;
import co.edu.uniquindio.stagepass.model.services.AuthService;

import java.time.LocalDateTime;

public class AuthServiceImp implements AuthService {
    private UsuarioRepository usuarioRepository;
    private Sesion sesionActual;
    public AuthServiceImp(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }
    @Override
    public Usuario login(String correo, String contrasena) {
        Usuario usuario = usuarioRepository.buscarPorCorreo(correo);
        if(usuario == null){
            throw new RuntimeException("Usuario no encontrado");
        }
        if(!usuario.getContrasena().equals(contrasena)){
            throw new RuntimeException("Contraseña incorrecta");
        }
        sesionActual = new Sesion(
                usuario,
                true,
                LocalDateTime.now()

        );
        return usuario;
    }

    @Override
    public Usuario registrar(String nombre, String correo, String telefono, String contrasenaHash) {
        return null;
    }

    @Override
    public void logout() {
        if(sesionActual != null){
            sesionActual.setActiva(false);
        }
        sesionActual = null;
    }

    @Override
    public Sesion obtenerSesionActual() {
        return sesionActual;
    }

    @Override
    public boolean haySesionActiva() {
        return sesionActual != null;
    }
}
