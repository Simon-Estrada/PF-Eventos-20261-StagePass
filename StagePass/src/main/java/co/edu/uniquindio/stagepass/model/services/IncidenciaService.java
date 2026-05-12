package co.edu.uniquindio.stagepass.model.services;

import co.edu.uniquindio.stagepass.model.Enums.TipoIncidencia;
import co.edu.uniquindio.stagepass.model.objects.Incidencia;
import co.edu.uniquindio.stagepass.model.objects.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public interface IncidenciaService {
    Incidencia registrarIncidenciaEvento(Usuario admin, String idEvento, TipoIncidencia tipo, String descripcion);
    Incidencia registrarIncidenciaCompra(Usuario admin, String idCompra, TipoIncidencia tipo, String descripcion);
    Incidencia registrarIncidenciaAutomatica(String idCompra, TipoIncidencia tipo, String descripcion);
    List<Incidencia> consultarIncidencias(Usuario admin, LocalDateTime inicio, LocalDateTime fin, TipoIncidencia tipo);
}
