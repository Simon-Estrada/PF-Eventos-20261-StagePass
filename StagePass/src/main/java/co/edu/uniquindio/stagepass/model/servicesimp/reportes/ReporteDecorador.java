package co.edu.uniquindio.stagepass.model.servicesimp.reportes;

import co.edu.uniquindio.stagepass.model.services.Reporte;

public abstract class ReporteDecorador implements Reporte {
    protected Reporte reporteBase;

    public ReporteDecorador(Reporte reporteBase) {
        this.reporteBase = reporteBase;
    }

    @Override
    public byte[] generar() {
        return reporteBase.generar();
    }
}
