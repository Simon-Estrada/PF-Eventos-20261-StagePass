package co.edu.uniquindio.stagepass.model.servicesimp.pagos;

import co.edu.uniquindio.stagepass.model.MetodoPagoUsuario;
import co.edu.uniquindio.stagepass.model.services.MetodoPago;

public class PagoDebito implements MetodoPago {
    @Override
    public boolean procesarPago(double monto, MetodoPagoUsuario datos) {
        if(datos == null){
            return false;
        }
        if(datos.getSaldo() >= monto){
            datos.setSaldo(datos.getSaldo() - monto);
            return true;
        }
        return false;
    }
}
