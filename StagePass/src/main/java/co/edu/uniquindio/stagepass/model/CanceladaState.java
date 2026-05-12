package co.edu.uniquindio.stagepass.model;

import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.services.CompraState;

public class CanceladaState implements CompraState {
    @Override
    public void confirmar(Compra compra) {
        throw new RuntimeException(
                "La compra fue cancelada"
        );
    }
    @Override
    public void cancelar(Compra compra) {
        throw new RuntimeException(
                "La compra ya está cancelada"
        );
    }
    @Override
    public String getNombreEstado() {

        return "CANCELADA";
    }
}
