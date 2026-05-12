package co.edu.uniquindio.stagepass.model.services;

import co.edu.uniquindio.stagepass.model.MetodoPagoUsuario;
import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.objects.Evento;
import co.edu.uniquindio.stagepass.model.objects.ItemCompra;
import co.edu.uniquindio.stagepass.model.objects.Usuario;

import java.util.List;

public interface CompraService {
    //RF-034
    public Compra crearCompra(Usuario usuario, Evento evento, List<ItemCompra> itemsCompra);
    //RF-035
    public void modificarCompra(String idCompra, List<ItemCompra> nuevosItems);
    public void agregarServicios(String idCompra, List<ServicioAdicional> servicios);
    //RF-036
    public void cancelarCompra(String idCompra);
    public void confirmarCompra(String idCompra);
    public void reembolsarCompra(String idCompra);
    //RF-037
    public Compra consultarCompra(String idCompra);
    public List<Compra> listarComprasUsuario(String idUsuario);
    public List<Compra> listarCompras();


}
