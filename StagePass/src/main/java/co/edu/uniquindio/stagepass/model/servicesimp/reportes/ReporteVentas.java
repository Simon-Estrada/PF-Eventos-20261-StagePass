package co.edu.uniquindio.stagepass.model.servicesimp.reportes;

import java.time.LocalDate;

public class ReporteVentas extends ReporteTemplate {

    public ReporteVentas(LocalDate inicio, LocalDate fin) {
        super(inicio, fin);
    }

    @Override
    protected Object obtenerDatos() {
        return "Datos crudos de Ventas (Ej: Compra 1: $100, Compra 2: $200)";
    }

    @Override
    protected Object procesarDatos(Object datos) {
        String datosString = (String) datos;
        return "--- REPORTE DE VENTAS (" + inicio + " a " + fin + ") ---\n" 
             + datosString + "\n"
             + "Total Calculado: $300";
    }
}
