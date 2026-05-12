package co.edu.uniquindio.stagepass.model.objects;

public class ServicioAdicional {
    private String idServicio;
    private String nombre;
    private double precio;

    public ServicioAdicional() {}

    public ServicioAdicional(String idServicio, String nombre, double precio) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getIdServicio() { return idServicio; }
    public void setIdServicio(String idServicio) { this.idServicio = idServicio; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
