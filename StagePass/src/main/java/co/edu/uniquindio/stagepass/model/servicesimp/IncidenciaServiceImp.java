package co.edu.uniquindio.stagepass.model.servicesimp;

import co.edu.uniquindio.stagepass.model.Enums.Rol;
import co.edu.uniquindio.stagepass.model.Enums.TipoIncidencia;
import co.edu.uniquindio.stagepass.model.objects.Incidencia;
import co.edu.uniquindio.stagepass.model.objects.Usuario;
import co.edu.uniquindio.stagepass.model.repositories.IncidenciaRepository;
import co.edu.uniquindio.stagepass.model.services.IncidenciaService;

import java.time.LocalDateTime;
import java.util.List;

public class IncidenciaServiceImp implements IncidenciaService {

    private final IncidenciaRepository incidenciaRepository;

    public IncidenciaServiceImp(IncidenciaRepository incidenciaRepository) {
        this.incidenciaRepository = incidenciaRepository;
    }

    private void validarAdministrador(Usuario usuario) {
        if (usuario == null || usuario.getRol() != Rol.ADMIN) {
            throw new RuntimeException("Acceso denegado: Solo los administradores pueden realizar esta acción.");
        }
    }

    @Override
    public Incidencia registrarIncidenciaEvento(Usuario admin, String idEvento, TipoIncidencia tipo, String descripcion) {
        validarAdministrador(admin);
        if (idEvento == null || idEvento.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del evento es obligatorio.");
        }
        Incidencia incidencia = new Incidencia(tipo, descripcion, idEvento, null);
        return incidenciaRepository.guardar(incidencia);
    }

    @Override
    public Incidencia registrarIncidenciaCompra(Usuario admin, String idCompra, TipoIncidencia tipo, String descripcion) {
        validarAdministrador(admin);
        if (idCompra == null || idCompra.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de la compra es obligatorio.");
        }
        Incidencia incidencia = new Incidencia(tipo, descripcion, null, idCompra);
        return incidenciaRepository.guardar(incidencia);
    }

    @Override
    public Incidencia registrarIncidenciaAutomatica(String idCompra, TipoIncidencia tipo, String descripcion) {
        if (idCompra == null || idCompra.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de la compra es obligatorio.");
        }
        Incidencia incidencia = new Incidencia(tipo, descripcion, null, idCompra);
        return incidenciaRepository.guardar(incidencia);
    }

    @Override
    public List<Incidencia> consultarIncidencias(Usuario admin, LocalDateTime inicio, LocalDateTime fin, TipoIncidencia tipo) {
        validarAdministrador(admin);
        return incidenciaRepository.buscarPorRangoYTipo(inicio, fin, tipo);
    }
}
