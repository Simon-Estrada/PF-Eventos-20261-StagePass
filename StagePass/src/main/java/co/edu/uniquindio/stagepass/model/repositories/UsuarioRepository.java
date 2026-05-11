package co.edu.uniquindio.stagepass.model.repositories;

import co.edu.uniquindio.stagepass.model.objects.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private List<Usuario> usuarios;

    public void UsuarioRepositoryImp() {
        usuarios = new ArrayList<>();
    }


    public void guardar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void actualizar(Usuario usuario) {
        Usuario usuarioEncontrado = buscarPorId(usuario.getIdUsuario());
        if (usuarioEncontrado != null) {
            usuarioEncontrado.setNombre(usuario.getNombre());
            usuarioEncontrado.setCorreo(usuario.getCorreo());
            usuarioEncontrado.setTelefono(usuario.getTelefono());
            usuarioEncontrado.setContrasena(usuario.getContrasena());
            usuarioEncontrado.setMetodosPago(usuario.getMetodosPago());
            usuarioEncontrado.setCompras(usuario.getCompras());
        }
    }

    public void eliminar(String idUsuario) {
        usuarios.removeIf(usuario -> usuario.getIdUsuario().equals(idUsuario)
        );
    }


    public Usuario buscarPorId(String idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                return usuario;
            }
        }
        return null;
    }


    public Usuario buscarPorCorreo(String correo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> listar() {
        return usuarios;
    }
}
