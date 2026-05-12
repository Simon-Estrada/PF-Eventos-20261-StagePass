package co.edu.uniquindio.stagepass.model;

import co.edu.uniquindio.stagepass.model.Enums.Rol;
import co.edu.uniquindio.stagepass.model.objects.Compra;
import co.edu.uniquindio.stagepass.model.objects.Evento;
import co.edu.uniquindio.stagepass.model.objects.ItemCompra;
import co.edu.uniquindio.stagepass.model.objects.Usuario;
import co.edu.uniquindio.stagepass.model.services.AuthService;
import co.edu.uniquindio.stagepass.model.services.CompraService;
import co.edu.uniquindio.stagepass.model.services.EventoService;
import co.edu.uniquindio.stagepass.model.services.UsuarioService;

import java.util.List;
//Esta clase funciona con el Patron Facade puesto que centraliza el acceso
//        a los servicios, Ademas de funcionar como singleton, permitiendo una unica
//instancia del sistema
public class SistemaEventos {
    private static SistemaEventos instance;

    private UsuarioService usuarioService;
    private EventoService eventoService;
    private CompraService compraService;
    private ReporteService reporteService;
    private AuthService authService;

    private SistemaEventos(){}

    public SistemaEventos getInstance() {
        if(instance==null){
            instance = new SistemaEventos();
        }
        return instance;
    }

    public void initialize(UsuarioService usuarioService, EventoService eventoService, CompraService compraService, ReporteService reporteService, AuthService authService) {
        this.usuarioService = usuarioService;
        this.eventoService = eventoService;
        this.compraService = compraService;
        this.reporteService = reporteService;
        this.authService = authService;
    }
    public Usuario registrarUsuario(String nombre, String correo, String telefono, String contrasena, Rol rol){
        return usuarioService.registrarUsuario(nombre, correo, telefono, contrasena, rol);
    }
    public List<Evento> listarEventos(){
        return eventoService.consultarEventos();
    }
    public Compra crearCompra(Usuario usuario, Evento evento, List<ItemCompra> itemsCompra){
        return compraService.crearCompra(usuario, evento, itemsCompra);
    }
    public byte[] generarReporteVentas() {
        return reporteService.generarReporte();
    }
}
