package co.edu.uniquindio.stagepass.model.factories;

import co.edu.uniquindio.stagepass.model.Enums.TipoMetodoPago;
import co.edu.uniquindio.stagepass.model.services.MetodoPago;
import co.edu.uniquindio.stagepass.model.servicesimp.pagos.PagoDebito;
import co.edu.uniquindio.stagepass.model.servicesimp.pagos.PagoEfectivo;

public class MetodoPagoFactory {
    public MetodoPago crear(TipoMetodoPago tipoMetodoPago){
        switch (tipoMetodoPago){
            case EFECTIVO:
                return new PagoEfectivo();
            case DEBITO:
                return new PagoDebito();
            default:
                throw new IllegalArgumentException("Método de pago no válido");
        }
    }
}
