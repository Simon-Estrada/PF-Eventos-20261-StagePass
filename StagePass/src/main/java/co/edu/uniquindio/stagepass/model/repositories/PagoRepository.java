package co.edu.uniquindio.stagepass.model.repositories;

import co.edu.uniquindio.stagepass.model.objects.Pago;

import java.util.ArrayList;
import java.util.List;

public class PagoRepository {
    private List<Pago> pagos;

    public PagoRepository() {
        this.pagos = new ArrayList<>();
    }

    public Pago guardar(Pago pago) {
        pagos.add(pago);
        return pago;
    }


    public Pago buscarPorId(String idPago) {
        for (Pago pago : pagos) {
            if (pago.getIdPago().equals(idPago)) {
                return pago;
            }
        }
        return null;
    }

    public List<Pago> listarPagoUsuario(String idUsuario) {
        List<Pago> pagosUsuario = new ArrayList<>();
        for (Pago pago : pagos) {
            if (pago.getCompra().getUsuario().getId().equals(idUsuario)) {
                pagosUsuario.add(pago);
            }
        }
        return pagosUsuario;
    }
}
