package co.edu.uniquindio.stagepass.model.servicesimp;

import co.edu.uniquindio.stagepass.model.objects.Asiento;
import co.edu.uniquindio.stagepass.model.objects.Zona;
import co.edu.uniquindio.stagepass.model.services.AsientoService;
import co.edu.uniquindio.stagepass.model.services.ZonaService;

import java.util.List;

public class AsientoServiceImp implements AsientoService {
    private final ZonaService zonaService;

    public AsientoServiceImp(ZonaService zonaService) {
        this.zonaService = zonaService;
    }


    @Override
    public void agregarAsiento(String idZona, Asiento asiento) {
        Zona zona= zonaService.buscarPorId(idZona);
        if(asiento==null){
            throw new IllegalArgumentException("El asiento es nulo.");
        }
        zona.getAsientos().add(asiento);

    }

    @Override
    public void actualizarAsiento(String idZona, Asiento asiento) {
        Zona zona = zonaService.buscarPorId(idZona);
        Asiento existe = buscarAsiento(zona, asiento.getIdAsiento());
        existe.setFila(asiento.getFila());
        existe.setNumero(asiento.getNumero());
        existe.setEstado(asiento.getEstado());

    }

    @Override
    public void eliminarAsiento(String idZona, String idAsiento) {
        Zona zona = zonaService.buscarPorId(idZona);
        Asiento asiento = buscarAsiento(zona, idAsiento);
        zona.getAsientos().remove(asiento);

    }

    @Override
    public void cambiarEstado(String idZona, String idAsiento, EstadoAsiento estado) {
        Zona zona= zonaService.buscarPorId(idZona);
        Asiento asiento=buscarAsiento(zona, idAsiento);
        asiento.setEstado(estado);

    }

    @Override
    public List<Asiento> consultarMapaAsientos(String idZona) {
        Zona zona = zonaService.buscarPorId(idZona);
        return zona.getAsientos();
    }
    private Asiento buscarAsiento(Zona zona, String idAsiento) {
        for (Asiento asiento : zona.getAsientos()) {
            if (asiento.getIdAsiento().equals(idAsiento)) {
                return asiento;
            }
        }
        throw new IllegalArgumentException("No existe un asiento con ese id.");
    }
}
