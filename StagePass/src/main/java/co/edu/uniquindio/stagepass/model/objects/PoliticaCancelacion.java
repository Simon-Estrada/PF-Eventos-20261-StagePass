package co.edu.uniquindio.stagepass.model.objects;

public class PoliticaCancelacion {
    private boolean permiteCancelacion;
    private int horasLimite;

    public PoliticaCancelacion(boolean permiteCancelacion, int horasLimite) {
        this.permiteCancelacion = permiteCancelacion;
        this.horasLimite = horasLimite;
    }

    public boolean isPermiteCancelacion() {
        return permiteCancelacion;
    }

    public void setPermiteCancelacion(boolean permiteCancelacion) {
        this.permiteCancelacion = permiteCancelacion;
    }

    public int getHorasLimite() {
        return horasLimite;
    }

    public void setHorasLimite(int horasLimite) {
        this.horasLimite = horasLimite;
    }
}
