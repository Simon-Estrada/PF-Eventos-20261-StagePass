package co.edu.uniquindio.stagepass.model.servicesimp;

import co.edu.uniquindio.stagepass.model.Enums.FormatoReporte;
import co.edu.uniquindio.stagepass.model.Enums.TipoReporte;
import co.edu.uniquindio.stagepass.model.services.Reporte;
import co.edu.uniquindio.stagepass.model.services.ReporteService;
import co.edu.uniquindio.stagepass.model.servicesimp.reportes.*;

import java.time.LocalDate;

public class ReporteServiceImp implements ReporteService {

    @Override
    public byte[] generarReporte(TipoReporte tipo, FormatoReporte formato, LocalDate inicio, LocalDate fin) {

        Reporte reporteBase;
        switch (tipo) {
            case VENTAS_PERIODO:
                reporteBase = new ReporteVentas(inicio, fin);
                break;
            case OCUPACION_ZONA:
                reporteBase = new ReporteOcupacion(inicio, fin);
                break;
            case TASA_CANCELACION:
                reporteBase = new ReporteCancelacion(inicio, fin);
                break;
            default:
                throw new IllegalArgumentException("Tipo de reporte no soportado: " + tipo);
        }

        Reporte reporteDecorado;
        if (formato == FormatoReporte.CSV) {
            reporteDecorado = new ReporteCSV(reporteBase);
        } else if (formato == FormatoReporte.PDF) {
            reporteDecorado = new ReportePDF(reporteBase);
        } else {
            throw new IllegalArgumentException("Formato no soportado: " + formato);
        }

        return reporteDecorado.generar();
    }
}
