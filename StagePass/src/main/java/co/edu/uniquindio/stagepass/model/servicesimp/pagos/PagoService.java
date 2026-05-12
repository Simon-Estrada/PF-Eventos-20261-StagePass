package co.edu.uniquindio.stagepass.model.servicesimp.pagos;

import co.edu.uniquindio.stagepass.model.CreadaState;
import co.edu.uniquindio.stagepass.model.Enums.EstadoPago;
import co.edu.uniquindio.stagepass.model.GeneradorIds;
import co.edu.uniquindio.stagepass.model.MetodoPagoUsuario;
import co.edu.uniquindio.stagepass.model.PagadaState;
import co.edu.uniquindio.stagepass.model.factories.MetodoPagoFactory;
import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.objects.Pago;
import co.edu.uniquindio.stagepass.model.repositories.CompraRepository;
import co.edu.uniquindio.stagepass.model.repositories.PagoRepository;
import co.edu.uniquindio.stagepass.model.services.MetodoPago;

import java.time.LocalDateTime;
import java.util.List;

public class PagoService {
    private PagoRepository pagoRepository;
    private IncidenciaService incidenciaService;
    private CompraRepository compraRepository;
    private MetodoPagoFactory metodoPagoFactory;

    public PagoService(PagoRepository pagoRepository, IncidenciaService incidenciaService, CompraRepository compraRepository, MetodoPagoFactory metodoPagoFactory) {
        this.pagoRepository = pagoRepository;
        this.incidenciaService = incidenciaService;
        this.compraRepository = compraRepository;
        this.metodoPagoFactory = metodoPagoFactory;
    }


    public Pago pagarCompra(Compra compra, MetodoPagoUsuario metodoPagoUsuario){
        if (compra == null) {
            throw new RuntimeException("La compra no existe");
        }
        if (metodoPagoUsuario == null) {
            throw new RuntimeException("Debe seleccionar un método de pago");
        }
        if (!metodoPagoUsuario.isActivo()) {
            throw new RuntimeException("El método de pago está inactivo");
        }
        if (!(compra.getEstado() instanceof CreadaState)) {
            throw new RuntimeException("La compra ya fue procesada");
        }
        MetodoPago metodoPago =
                metodoPagoFactory.crear(metodoPagoUsuario.getTipoMetodoPago());

        boolean pagoExitoso =
                metodoPago.procesarPago(compra.getTotal(), metodoPagoUsuario);
        if (!pagoExitoso){
            incidenciaService.registrarIncidencia(
                    "PAGO_RECHAZADO",
                    "El pago no pudo procesarse"
            );
            throw new RuntimeException("El pago fue rechazado");
        }
        Pago pago = new Pago(GeneradorIds.generarIdPago(), compra, compra.getTotal(), LocalDateTime.now(), EstadoPago.APROBADO, metodoPagoUsuario
        );

        compra.setEstado(new PagadaState());
        pagoRepository.guardar(pago);
        compraRepository.actualizar(compra);
        return pago;
    }
    public List<Pago> obtenerPagosUsuario(String idUsuario){
        return pagoRepository.listarPagoUsuario(idUsuario);

    }
}
