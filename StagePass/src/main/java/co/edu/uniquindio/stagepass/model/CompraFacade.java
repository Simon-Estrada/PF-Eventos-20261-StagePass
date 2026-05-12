package co.edu.uniquindio.stagepass.model;

import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.objects.Evento;
import co.edu.uniquindio.stagepass.model.objects.ItemCompra;
import co.edu.uniquindio.stagepass.model.objects.Usuario;
import co.edu.uniquindio.stagepass.model.services.CompraService;
import co.edu.uniquindio.stagepass.model.servicesimp.pagos.PagoService;

import java.util.List;

public class CompraFacade {
    private final CompraService compraService;
    private final IncidenciaService incidenciaService;
    private final PagoService pagoService;
    public CompraFacade(CompraService compraService, IncidenciaService incidenciaService, PagoService pagoService) {
        this.compraService = compraService;
        this.incidenciaService = incidenciaService;
        this.pagoService = pagoService;
    }
    public Compra realizarCompra(Usuario usuario, Evento evento, List<ItemCompra> items, MetodoPagoUsuario metodoPagoUsuario) {
        try {
            Compra compra = compraService.crearCompra(usuario, evento, items);
            pagoService.pagarCompra(compra, metodoPagoUsuario);
            compraService.confirmarCompra(compra.getIdCompra());
            return compra;

        } catch (Exception e) {
            incidenciaService.registrarIncidencia("ERROR_COMPRA", e.getMessage()
            );
            throw new RuntimeException("No fue posible realizar la compra");
        }
    }
}
