package co.edu.uniquindio.stagepass.model.servicesimp.reportes;

import java.time.LocalDate;

public class ReporteCancelacion extends ReporteTemplate {

    public ReporteCancelacion(LocalDate inicio, LocalDate fin) {
        super(inicio, fin);
    }

    @Override
    protected Object obtenerDatos() {

        return "Datos crudos: 100 Compras Totales, 5 Compras Canceladas";
    }

    @Override
    protected Object procesarDatos(Object datos) {

        return "--- REPORTE TASA DE CANCELACION ---\n"
             + "Total de Compras Realizadas: 100\n"
             + "Total de Compras Canceladas: 5\n"
             + "Tasa de Cancelación Actual: 5.0%";
    }
}
