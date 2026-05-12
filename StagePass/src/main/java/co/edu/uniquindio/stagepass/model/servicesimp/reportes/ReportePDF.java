package co.edu.uniquindio.stagepass.model.servicesimp.reportes;

import co.edu.uniquindio.stagepass.model.services.Reporte;

public class ReportePDF extends ReporteDecorador {

    public ReportePDF(Reporte reporteBase) {
        super(reporteBase);
    }

    @Override
    public byte[] generar() {
        byte[] rawBytes = super.generar();
        String rawDatos = new String(rawBytes);
        
        // Simulación de estructura de documento PDF
        String pdfData = "%%% PDF-1.4 %%%\n";
        pdfData += "<< /Title (Reporte StagePass) >>\n";
        pdfData += "CONTENIDO DEL REPORTE:\n\n";
        pdfData += rawDatos + "\n";
        pdfData += "%%EOF\n";
        
        return pdfData.getBytes();
    }
}
