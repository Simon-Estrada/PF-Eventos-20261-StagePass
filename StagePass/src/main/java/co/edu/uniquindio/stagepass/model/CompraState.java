package co.edu.uniquindio.stagepass.model;

import co.edu.uniquindio.stagepass.model.objects.Compra;

public class CompraState implements co.edu.uniquindio.stagepass.model.services.CompraState {

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
