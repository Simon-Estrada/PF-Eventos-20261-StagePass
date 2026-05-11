package co.edu.uniquindio.stagepass.model.services;

import co.edu.uniquindio.stagepass.model.MetodoPagoUsuario;

public interface MetodoPago {
    public boolean procesarPago(double monto, MetodoPagoUsuario datos);
}
