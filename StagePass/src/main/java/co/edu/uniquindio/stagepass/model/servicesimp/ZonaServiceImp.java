package co.edu.uniquindio.stagepass.model.servicesimp;

import co.edu.uniquindio.stagepass.model.objects.Asiento;
import co.edu.uniquindio.stagepass.model.objects.Zona;
import co.edu.uniquindio.stagepass.model.services.ZonaService;

import java.util.List;

public class ZonaServiceImp implements ZonaService {
    private final List<Zona> zonas;

    public ZonaServiceImp(List<Zona> zonas) {
        this.zonas = zonas;
    }

    @Override
    public Zona crearZona(Zona zona) {
        if(zona==null){
            throw new IllegalArgumentException("La zona es nula.");
        }
        validarDatos(zona);
        zonas.add(zona);
        return zona;
    }

    @Override
    public void actualizarZona(Zona zona) {
        if(zona==null){
            throw new IllegalArgumentException("la zona es nula.");
        }
        Zona existe= buscarPorId(zona.getIdZona());
        existe.setNombre(zona.getNombre());
        existe.setCapacidad(zona.getCapacidad());
        existe.setPrecioBase(zona.getPrecioBase());

    }

    @Override
    public void eliminarZona(String idZona) {
        Zona zona = buscarPorId(idZona);
        zonas.remove(zona);

    }

    @Override
    public List<Zona> consultarZonas() {
        return zonas;
    }

    @Override
    public Zona buscarPorId(String idZona) {
        if (idZona == null || idZona.isBlank()) {
            throw new IllegalArgumentException("El id es inválido.");
        }
        for (Zona zona : zonas) {
            if (zona.getIdZona().equals(idZona)) {
                return zona;
            }
        }
        throw new IllegalArgumentException("No existe una zona con ese id.");
    }

    @Override
    public void definirPrecioBase(String idZona, double precio) {
        Zona zona = buscarPorId(idZona);
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        zona.setPrecioBase(precio);

    }

    @Override
    public void definirCapacidad(String idZona, int capacidad) {
        Zona zona = buscarPorId(idZona);
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        }
        zona.setCapacidad(capacidad);
    }

    @Override
    public double consultarOcupacion(String idZona) {
        Zona zona= buscarPorId(idZona);
        int capacidad= zona.getCapacidad();
        int asientosOcupados= 0;
        for(Asiento asiento: zona.getAsientos()){
            if(asiento.getEstado()==EstadoAsiento.VENDIDO||asiento.getEstado()==EstadoAsiento.RESERVADO){
                asientosOcupados++;
            }
        }
        return ((double)asientosOcupados/capacidad)*100;
    }
    private void validarDatos(Zona zona) {
        if (zona.getNombre() == null || zona.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }
        if (zona.getCapacidad() <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        }
        if (zona.getPrecioBase() <= 0) {
            throw new IllegalArgumentException("El precio base debe ser mayor a 0.");
        }
    }

}


