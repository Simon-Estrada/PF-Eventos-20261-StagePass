package co.edu.uniquindio.stagepass.model.servicesimp.reportes;

import java.time.LocalDate;

public class ReporteOcupacion extends ReporteTemplate {

    public ReporteOcupacion(LocalDate inicio, LocalDate fin) {
        super(inicio, fin);
    }

    @Override
    protected Object obtenerDatos() {
        // En una implementación real, se llamarían a los repositorios
        // de Zonas y Asientos para revisar estados.
        return "Datos crudos de Asientos: 90 vendidos en VIP, 50 vendidos en General";
    }

    @Override
    protected Object procesarDatos(Object datos) {
        // Lógica para calcular porcentajes
        return "--- REPORTE DE OCUPACION POR ZONA ---\n" 
             + "Zona VIP: 90% Ocupación\n" 
             + "Zona General: 50% Ocupación";
    }
}
