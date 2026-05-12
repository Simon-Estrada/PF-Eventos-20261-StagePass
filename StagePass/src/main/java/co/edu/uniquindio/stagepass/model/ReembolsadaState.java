package co.edu.uniquindio.stagepass.model;

import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.services.CompraState;

public class ReembolsadaState implements CompraState {
    @Override
    public void confirmar(Compra compra) {
        throw new RuntimeException(
                "La compra fue reembolsada"
        );
    }
    @Override
    public void cancelar(Compra compra) {
        throw new RuntimeException(
                "La compra ya fue reembolsada"
        );
    }
    @Override
    public String getNombreEstado() {
        return "REEMBOLSADA";
    }
}
