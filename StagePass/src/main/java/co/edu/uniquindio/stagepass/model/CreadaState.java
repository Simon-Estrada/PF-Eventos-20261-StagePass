package co.edu.uniquindio.stagepass.model;

import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.services.CompraState;

public class CreadaState implements CompraState {
    @Override
    public void confirmar(Compra compra) {
        compra.setEstado(new PagadaState());
    }

    @Override
    public void cancelar(Compra compra) {
        compra.setEstado(new CanceladaState());
    }

    @Override
    public String getNombreEstado() {
        return "CREADA";
    }
}
