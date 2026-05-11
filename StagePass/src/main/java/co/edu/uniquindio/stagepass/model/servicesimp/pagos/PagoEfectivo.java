package co.edu.uniquindio.stagepass.model.servicesimp.pagos;

import co.edu.uniquindio.stagepass.model.MetodoPagoUsuario;
import co.edu.uniquindio.stagepass.model.services.MetodoPago;

public class PagoEfectivo implements MetodoPago {
    @Override
    public boolean procesarPago(double monto, MetodoPagoUsuario datos) {
        return true;
    }
}
