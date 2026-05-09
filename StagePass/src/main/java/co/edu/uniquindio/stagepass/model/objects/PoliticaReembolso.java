package co.edu.uniquindio.stagepass.model.objects;

public class PoliticaReembolso {
    private boolean permiteReembolso;
    private double porcentajeReembolso;

    public PoliticaReembolso(boolean permiteReembolso, double porcentajeReembolso) {
        this.permiteReembolso = permiteReembolso;
        this.porcentajeReembolso = porcentajeReembolso;
    }

    public boolean isPermiteReembolso() {
        return permiteReembolso;
    }

    public void setPermiteReembolso(boolean permiteReembolso) {
        this.permiteReembolso = permiteReembolso;
    }

    public double getPorcentajeReembolso() {
        return porcentajeReembolso;
    }

    public void setPorcentajeReembolso(double porcentajeReembolso) {
        this.porcentajeReembolso = porcentajeReembolso;
    }
}
