package co.edu.uniquindio.stagepass.model.repositories;

import co.edu.uniquindio.stagepass.model.Enums.TipoIncidencia;
import co.edu.uniquindio.stagepass.model.objects.Incidencia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class IncidenciaRepository {
    private final List<Incidencia> incidencias;

    public IncidenciaRepository() {
        this.incidencias = new ArrayList<>();
    }

    public IncidenciaRepository(List<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }

    public Incidencia guardar(Incidencia incidencia) {
        incidencias.add(incidencia);
        return incidencia;
    }

    public List<Incidencia> obtenerTodas() {
        return incidencias;
    }

    public List<Incidencia> buscarPorRangoYTipo(LocalDateTime inicio, LocalDateTime fin, TipoIncidencia tipo) {
        List<Incidencia> filtradas = new ArrayList<>();
        for (Incidencia incidencia : incidencias) {
            boolean coincideTipo = (tipo == null || incidencia.getTipo() == tipo);
            boolean despuesDeInicio = (inicio == null || !incidencia.getFechaRegistro().isBefore(inicio));
            boolean antesDeFin = (fin == null || !incidencia.getFechaRegistro().isAfter(fin));

            if (coincideTipo && despuesDeInicio && antesDeFin) {
                filtradas.add(incidencia);
            }
        }
        return filtradas;
    }

    public Incidencia buscarPorId(String idIncidencia) {
        for (Incidencia incidencia : incidencias) {
            if (incidencia.getIdIncidencia().equals(idIncidencia)) {
                return incidencia;
            }
        }
        return null;
    }
}
