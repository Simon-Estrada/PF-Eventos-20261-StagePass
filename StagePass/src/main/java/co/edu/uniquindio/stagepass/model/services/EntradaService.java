package co.edu.uniquindio.stagepass.model.services;

import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.objects.Entrada;

import java.util.List;

public interface EntradaService {
    List<Entrada> generarEntradas(Compra compra);
    List<Entrada> listarEntradasPorCompra(String idCompra);
    List<Entrada> listarEntradasPorEvento(String idEvento);
    void anularEntrada(String idEntrada);
    void marcarEntradaComoUsada(String idEntrada);
}
