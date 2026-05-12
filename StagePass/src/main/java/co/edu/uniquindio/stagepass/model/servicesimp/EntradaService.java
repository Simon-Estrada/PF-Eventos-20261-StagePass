package co.edu.uniquindio.stagepass.model.servicesimp;

import co.edu.uniquindio.stagepass.model.Enums.EstadoAsiento;
import co.edu.uniquindio.stagepass.model.Enums.EstadoEntrada;
import co.edu.uniquindio.stagepass.model.GeneradorIds;
import co.edu.uniquindio.stagepass.model.PagadaState;
import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.objects.Entrada;
import co.edu.uniquindio.stagepass.model.objects.ItemCompra;
import co.edu.uniquindio.stagepass.model.repositories.EntradaRepository;

import java.util.ArrayList;
import java.util.List;

public class EntradaService {
    private final EntradaRepository entradaRepository;

    public EntradaService(EntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }

    //RF-038
    public List<Entrada> generarEntradas(Compra compra) {
        if (compra == null) {
            throw new RuntimeException("La compra no puede ser null");
        }
        if (!(compra.getEstado() instanceof PagadaState)) {
            throw new RuntimeException("Solo se pueden generar entradas de compras pagadas");
        }
        List<Entrada> entradasGeneradas = new ArrayList<>();
        for (ItemCompra item : compra.getItemsCompra()) {
            Entrada entrada = new Entrada(
                    GeneradorIds.generarIdEntrada(),
                    compra.getEvento(),
                    item.getZona(),
                    item.getAsiento(),
                    compra,
                    item.getPrecioFinal()
            );
            if (item.getAsiento() != null) {
                item.getAsiento().setEstadoAsiento(EstadoAsiento.VENDIDO);
            }
            entradaRepository.guardar(entrada);
            entradasGeneradas.add(entrada);

        }
        compra.setEntradas(entradasGeneradas);
        return entradasGeneradas;
    }

    //RF-039
    public List<Entrada> listarEntradasPorCompra(String idCompra) {
        if (idCompra == null || idCompra.isBlank()) {
            throw new RuntimeException("El id de la compra es obligatorio");
        }
        return entradaRepository.listarPorCompra(idCompra);
    }

    //RF-039
    public List<Entrada> listarEntradasPorEvento(String idEvento) {
        if (idEvento == null || idEvento.isBlank()) {
            throw new RuntimeException("El id del evento es obligatorio");
        }
        return entradaRepository.listarPorEvento(idEvento);
    }

    //RF-040
    public void anularEntrada(String idEntrada) {
        Entrada entrada = entradaRepository.buscarPorId(idEntrada);
        if (entrada == null) {
            throw new RuntimeException("La entrada no existe");
        }
        if (entrada.getEstadoEntrada() == EstadoEntrada.ANULADA) {
            throw new RuntimeException("La entrada ya está anulada");
        }
        entrada.setEstadoEntrada(EstadoEntrada.ANULADA);
        if (entrada.getAsiento() != null) {
            entrada.getAsiento().setEstadoAsiento(EstadoAsiento.DISPONIBLE);
        }
    }

    public void marcarEntradaComoUsada(String idEntrada) {
        Entrada entrada = entradaRepository.buscarPorId(idEntrada);
        if (entrada == null) {
            throw new RuntimeException("La entrada no existe");
        }
        if (entrada.getEstadoEntrada() == EstadoEntrada.ANULADA) {
            throw new RuntimeException("No se puede usar una entrada anulada");
        }
        if (entrada.getEstadoEntrada() == EstadoEntrada.USADA) {
            throw new RuntimeException("La entrada ya fue utilizada");
        }
        entrada.setEstadoEntrada(EstadoEntrada.USADA);
    }
}
