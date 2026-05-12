package co.edu.uniquindio.stagepass.model.objects;

public class ItemCompra {
    private Asiento asiento;
    private double precio;

    public ItemCompra() {}

    public ItemCompra(Asiento asiento, double precio) {
        this.asiento = asiento;
        this.precio = precio;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
