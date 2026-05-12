package co.edu.uniquindio.stagepass.model.repositories;

import co.edu.uniquindio.stagepass.model.objects.Entrada;

import java.util.ArrayList;
import java.util.List;

public class EntradaRepository {
    private final List<Entrada> entradas;

    public EntradaRepository() {
        this.entradas = new ArrayList<>();
    }

    public Entrada guardar(Entrada entrada) {
        Entrada entradaExistente = buscarPorId(entrada.getIdEntrada());
        if (entradaExistente != null) {
            entradas.remove(entradaExistente);
        }
        entradas.add(entrada);
        return entrada;
    }

    public Entrada buscarPorId(String idEntrada) {
        for (Entrada entrada : entradas) {
            if (entrada.getIdEntrada().equals(idEntrada)) {
                return entrada;
            }
        }
        return null;
    }

    public List<Entrada> listarTodas() {
        return new ArrayList<>(entradas);
    }

    public List<Entrada> listarPorCompra(String idCompra) {
        List<Entrada> resultado = new ArrayList<>();
        for (Entrada entrada : entradas) {
            if (entrada.getCompra().getIdCompra().equals(idCompra)) {
                resultado.add(entrada);
            }
        }
        return resultado;
    }

    public List<Entrada> listarPorEvento(String idEvento) {
        List<Entrada> resultado = new ArrayList<>();
        for (Entrada entrada : entradas) {
            if (entrada.getEvento().getIdEvento().equals(idEvento)) {
                resultado.add(entrada);
            }
        }
        return resultado;
    }

    public void eliminar(String idEntrada) {
        Entrada entrada = buscarPorId(idEntrada);
        if (entrada != null) {
            entradas.remove(entrada);
        }
    }
}
