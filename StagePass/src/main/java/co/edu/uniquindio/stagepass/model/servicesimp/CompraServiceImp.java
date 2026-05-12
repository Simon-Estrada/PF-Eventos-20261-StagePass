package co.edu.uniquindio.stagepass.model.servicesimp;


import co.edu.uniquindio.stagepass.model.CreadaState;
import co.edu.uniquindio.stagepass.model.GeneradorIds;
import co.edu.uniquindio.stagepass.model.ReembolsadaState;
import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.objects.Evento;
import co.edu.uniquindio.stagepass.model.objects.ItemCompra;
import co.edu.uniquindio.stagepass.model.objects.ServicioAdicional;
import co.edu.uniquindio.stagepass.model.objects.Usuario;
import co.edu.uniquindio.stagepass.model.objects.Entrada;
import co.edu.uniquindio.stagepass.model.objects.Asiento;
import co.edu.uniquindio.stagepass.model.objects.Zona;
import co.edu.uniquindio.stagepass.model.Enums.EstadoEntrada;

import co.edu.uniquindio.stagepass.model.repositories.CompraRepository;
import co.edu.uniquindio.stagepass.model.services.CompraService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompraServiceImp implements CompraService {
    private final CompraRepository compraRepository;

    public CompraServiceImp(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }


    @Override
    public Compra crearCompra(Usuario usuario, Evento evento, List<ItemCompra> itemsCompra) {
        if (usuario == null) {
            throw new RuntimeException("El usuario es obligatorio");
        }
        if (evento == null) {
            throw new RuntimeException("El evento es obligatorio");
        }
        if (itemsCompra == null || itemsCompra.isEmpty()) {
            throw new RuntimeException(
                    "La compra debe tener al menos un item"
            );
        }
        List<Entrada> entradas = new ArrayList<>();
        Compra compra = Compra.builder()
                .idCompra(GeneradorIds.generarIdCompra())
                .usuario(usuario)
                .evento(evento)
                .fechaCreacion(LocalDateTime.now())
                .estado(new CreadaState())
                .itemsCompra(itemsCompra)
                .serviciosAdicionales(new ArrayList<>())
                .entradas(entradas)
                .total(0)
                .build();

        for (ItemCompra item : itemsCompra) {
            Asiento asiento = item.getAsiento();
            Zona zonaAsiento = null;
            if (evento.getRecinto() != null && evento.getRecinto().getZonas() != null) {
                for (Zona zona : evento.getRecinto().getZonas()) {
                    if (zona.getAsientos().contains(asiento)) {
                        zonaAsiento = zona;
                        break;
                    }
                }
            }
            
            Entrada entrada = new Entrada(
                    GeneradorIds.generarIdEntrada(),
                    evento,
                    zonaAsiento,
                    asiento,
                    compra,
                    item.getPrecio(),
                    EstadoEntrada.ACTIVA
            );
            entradas.add(entrada);
        }

        calcularTotal(compra);
        return compraRepository.guardar(compra);
    }

    @Override
    public void modificarCompra(String idCompra, List<ItemCompra> nuevosItems) {
        Compra compra = consultarCompra(idCompra);
        validarCompraEditable(compra);
        if (nuevosItems == null || nuevosItems.isEmpty()) {
            throw new RuntimeException("La compra debe tener al menos un item");
        }
        compra.setItemsCompra(nuevosItems);
        calcularTotal(compra);
        compraRepository.guardar(compra);
    }

    @Override
    public void agregarServicios(String idCompra, List<ServicioAdicional> servicios) {
        Compra compra = consultarCompra(idCompra);
        validarCompraEditable(compra);
        compra.getServiciosAdicionales().addAll(servicios);
        calcularTotal(compra);
        compraRepository.guardar(compra);
    }

    @Override
    public void cancelarCompra(String idCompra) {
        Compra compra = consultarCompra(idCompra);
        compra.getEstado().cancelar(compra);
        compraRepository.guardar(compra);
    }

    @Override
    public void confirmarCompra(String idCompra) {
        Compra compra = consultarCompra(idCompra);
        compra.getEstado().confirmar(compra);
        compraRepository.guardar(compra);
    }

    @Override
    public void reembolsarCompra(String idCompra) {
        Compra compra = consultarCompra(idCompra);
        compra.setEstado(new ReembolsadaState());
        compraRepository.guardar(compra);
    }

    @Override
    public Compra consultarCompra(String idCompra) {
        Compra compra = compraRepository.buscarPorId(idCompra);
        if (compra == null) {
            throw new RuntimeException("La compra no existe");
        }
        return compra;
    }

    @Override
    public List<Compra> listarComprasUsuario(String idUsuario) {
        return compraRepository.listarComprasUsuario(idUsuario);
    }

    @Override
    public List<Compra> listarCompras() {
        return compraRepository.listar();
    }

    private void calcularTotal(Compra compra) {
        double total = 0;
        for (ItemCompra item : compra.getItemsCompra()) {
            total += item.getPrecio();
        }
        for (ServicioAdicional servicio : compra.getServiciosAdicionales()) {
            total += servicio.getPrecio();
        }
        compra.setTotal(total);
    }

    private void validarCompraEditable(Compra compra) {
        if (!(compra.getEstado() instanceof CreadaState)) {
            throw new RuntimeException("La compra no puede modificarse");
        }
    }
}
