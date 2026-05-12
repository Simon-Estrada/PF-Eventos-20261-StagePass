package co.edu.uniquindio.stagepass.model.servicesimp.reportes;

import co.edu.uniquindio.stagepass.model.services.Reporte;
import java.time.LocalDate;

public abstract class ReporteTemplate implements Reporte {
    protected LocalDate inicio;
    protected LocalDate fin;

    public ReporteTemplate(LocalDate inicio, LocalDate fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public final byte[] generar() {
        Object datos = obtenerDatos();
        Object datosProcesados = procesarDatos(datos);
        return formatear(datosProcesados);
    }

    protected abstract Object obtenerDatos();
    
    protected abstract Object procesarDatos(Object datos);
    
    protected byte[] formatear(Object datos) {
        if (datos == null) return new byte[0];
        return datos.toString().getBytes();
    }
}
