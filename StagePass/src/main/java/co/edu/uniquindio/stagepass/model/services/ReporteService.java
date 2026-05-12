package co.edu.uniquindio.stagepass.model.services;

import co.edu.uniquindio.stagepass.model.Enums.FormatoReporte;
import co.edu.uniquindio.stagepass.model.Enums.TipoReporte;
import java.time.LocalDate;

public interface ReporteService {
    byte[] generarReporte(TipoReporte tipo, FormatoReporte formato, LocalDate inicio, LocalDate fin);
}
