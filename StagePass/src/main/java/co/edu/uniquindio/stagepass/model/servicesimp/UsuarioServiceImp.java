package co.edu.uniquindio.stagepass.model.servicesimp;

import co.edu.uniquindio.stagepass.model.Enums.Rol;
import co.edu.uniquindio.stagepass.model.MetodoPagoUsuario;
import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.objects.Usuario;
import co.edu.uniquindio.stagepass.model.repositories.UsuarioRepository;
import co.edu.uniquindio.stagepass.model.services.UsuarioService;

import java.util.ArrayList;
import java.util.List;

public class UsuarioServiceImp implements UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario registrarUsuario(String nombre, String correo, String telefono, String contrasena, Rol rol) {
        Usuario usuarioExistente = usuarioRepository.buscarPorCorreo(correo);

        if (usuarioExistente != null) {
            throw new RuntimeException("Ya existe un usuario con ese correo");
        }

        Usuario usuario = new Usuario(
                nombre,
                correo,
                telefono,
                contrasena,
                rol,
                new ArrayList<>(),
                new ArrayList<>()
        );

        usuarioRepository.guardar(usuario);

        return usuario;
    }


    @Override
    public void actualizarPerfil(Usuario usuario) {
        Usuario usuarioExistente =
                usuarioRepository.buscarPorId(usuario.getIdUsuario());

        if (usuarioExistente == null) {
            throw new RuntimeException("El usuario no existe");
        }
        usuarioRepository.actualizar(usuario);
    }

    @Override
    public Usuario obtenerUsuario(String idUsuario) {
        return usuarioRepository.buscarPorId(idUsuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listar();
    }

    @Override
    public void eliminarUsuario(String idUsuario) {
        Usuario usuario =
                usuarioRepository.buscarPorId(idUsuario);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.eliminar(idUsuario);
    }

    @Override
    public void agregarMetodoPago(String idUsuario, MetodoPagoUsuario metodoPago) {
        Usuario usuario = usuarioRepository.buscarPorId(idUsuario);

        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuario.getMetodosPago().add(metodoPago);
        usuarioRepository.actualizar(usuario);

    }

    @Override
    public void eliminarMetodoPago(String idUsuario, String idMetodoPago) {
        Usuario usuario = usuarioRepository.buscarPorId(idUsuario);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuario.getMetodosPago().removeIf(metodo -> metodo.getId().equals(idMetodoPago)
        );
        usuarioRepository.actualizar(usuario);

    }

    @Override
    public List<MetodoPagoUsuario> obtenerMetodosPago(String idUsuario) {
        Usuario usuario =
                usuarioRepository.buscarPorId(idUsuario);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        return usuario.getMetodosPago();
    }

    @Override
    public List<Compra> obtenerComprasUsuario(String idUsuario) {
        Usuario usuario =
                usuarioRepository.buscarPorId(idUsuario);

        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        return usuario.getCompras();
    }
}
