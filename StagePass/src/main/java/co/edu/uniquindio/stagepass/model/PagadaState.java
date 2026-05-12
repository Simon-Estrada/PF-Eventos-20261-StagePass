package co.edu.uniquindio.stagepass.model;

import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.services.CompraState;

public class PagadaState implements CompraState {
    @Override
    public void confirmar(Compra compra) {
        compra.setEstado(new ConfirmadaState());
    }
    @Override
    public void cancelar(Compra compra) {
        compra.setEstado(new ReembolsadaState());
    }
    @Override
    public String getNombreEstado() {
        return "PAGADA";
    }
}
