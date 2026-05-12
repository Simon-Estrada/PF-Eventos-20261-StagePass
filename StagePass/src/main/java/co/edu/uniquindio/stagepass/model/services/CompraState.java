package co.edu.uniquindio.stagepass.model.services;

import co.edu.uniquindio.stagepass.model.objects.Compra;

public interface CompraState {
    void confirmar(Compra compra);
    void cancelar(Compra compra);
    String getNombreEstado();

}
