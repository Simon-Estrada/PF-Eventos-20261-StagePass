package co.edu.uniquindio.stagepass.model.repositories;

import co.edu.uniquindio.stagepass.model.objects.Compra;

import java.util.ArrayList;
import java.util.List;

public class CompraRepository {
    private final List<Compra> compras;

    public CompraRepository(List<Compra> compras) {
        this.compras = compras;
    }

    public Compra guardar(Compra compra) {
        compras.add(compra);
        return compra;
    }

    public Compra buscarPorId(String idCompra) {
        for (Compra compra : compras) {
            if (compra.getIdCompra().equals(idCompra)) {
                return compra;
            }
        }
        return null;
    }

    public List<Compra> obtenerCompras() {
        return compras;
    }

    public void actualizar(Compra compraActualizada) {
        for (int i = 0; i < compras.size(); i++) {
            Compra compra = compras.get(i);
            if (compra.getIdCompra().equals(compraActualizada.getIdCompra())) {
                compras.set(i, compraActualizada);
                return;
            }
        }
        throw new RuntimeException("La compra no existe");
    }

    public List<Compra> listarComprasUsuario(String idUsuario) {
        List<Compra> comprasUsuario = new ArrayList<>();
        for (Compra compra : compras) {
            if (compra.getUsuario().getIdUsuario().equals(idUsuario)) {comprasUsuario.add(compra);
            }
        }
        return comprasUsuario;
    }
    public List<Compra> listar(){
        return compras;
    }

}
