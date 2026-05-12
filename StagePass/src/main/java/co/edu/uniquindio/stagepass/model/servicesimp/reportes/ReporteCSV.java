package co.edu.uniquindio.stagepass.model.servicesimp.reportes;

import co.edu.uniquindio.stagepass.model.services.Reporte;

public class ReporteCSV extends ReporteDecorador {

    public ReporteCSV(Reporte reporteBase) {
        super(reporteBase);
    }

    @Override
    public byte[] generar() {
        byte[] rawBytes = super.generar();
        String rawDatos = new String(rawBytes);
        
        // Simulación de conversión a CSV
        String csvData = "columna1,columna2,columna3\n";
        csvData += rawDatos + "\n";
        
        return csvData.getBytes();
    }
}
