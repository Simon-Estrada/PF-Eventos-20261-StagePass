package co.edu.uniquindio.stagepass.model;

import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.services.CompraState;

public class ConfirmadaState implements CompraState {
    @Override
    public void confirmar(Compra compra) {
        throw new RuntimeException(
                "La compra ya está confirmada"
        );
    }
    @Override
    public void cancelar(Compra compra) {
        throw new RuntimeException(
                "No se puede cancelar una compra confirmada"
        );
    }
    @Override
    public String getNombreEstado() {
        return "CONFIRMADA";
    }
}
