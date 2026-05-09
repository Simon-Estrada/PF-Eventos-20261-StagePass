package co.edu.uniquindio.stagepass.model.objects;

public class Usuario {
    private String idUsuario;
    private String nombre;
    private String correo;
    private String telefono;
    private String contrasenaHash;
    private Rol rol;
    private List<MetodosPagoUsuario> metodosPago;
    private List<Pago> historialPagos;

    public Usuario(String idUsuario, String correo, String nombre, String telefono, String contrasenaHash, Rol rol, List<MetodosPagoUsuario> metodosPago, List<Pago> historialPagos) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contrasenaHash = contrasenaHash;
        this.rol = rol;
        this.metodosPago = metodosPago;
        this.historialPagos = historialPagos;
    }
}
