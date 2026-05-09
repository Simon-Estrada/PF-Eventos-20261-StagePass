package co.edu.uniquindio.stagepass.model;

import co.edu.uniquindio.stagepass.model.services.EventoService;

public class SistemaEventos {
    private SistemaEventos instance;
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
    public Usuario registrarUsuario(String nombre, String correo, String telefono, String contrasenaHash){
        return usuarioService.registrar(nombre, correo, telefono, contrasenaHash);
    }
    public List<Evento> listarEventos(){
        return eventoService.obtenerEventos();
    }
    public Compra crearCompra(Usuario usuario, Evento evento){
        return compraService.crearCompra(usuario, evento);
    }
    public void generarReporteVentas(){
        return reporteService.generarReporte();
    }
}
