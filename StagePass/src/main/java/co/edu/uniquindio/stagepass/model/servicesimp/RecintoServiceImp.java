package co.edu.uniquindio.stagepass.model.servicesimp;

import co.edu.uniquindio.stagepass.model.objects.Recinto;
import co.edu.uniquindio.stagepass.model.objects.Zona;
import co.edu.uniquindio.stagepass.model.repositories.RecintoRepository;
import co.edu.uniquindio.stagepass.model.services.RecintoService;

import java.util.List;

public class RecintoServiceImp implements RecintoService {
    public final RecintoRepository recintoRepository;

    public RecintoServiceImp(RecintoRepository recintoRepository) {
        this.recintoRepository = recintoRepository;
    }

    @Override
    public Recinto crearRecinto(Recinto recinto) {
        if(recinto == null){
            throw new IllegalArgumentException("El recinto es nulo.");
        }
        validarDatos(recinto);

        return recintoRepository.guardar(recinto);
    }

    @Override
    public void actualizarRecinto(Recinto recinto) {
        if(recinto==null){
            throw new IllegalArgumentException("El recinto es nulo.");
        }
        validarDatos(recinto);
        Recinto existe = buscarPorId(recinto.getIdRecinto());
        if(existe==null){
            throw new IllegalArgumentException("El recinto no existe.");
        }
        recintoRepository.actualizar(recinto);

    }

    @Override
    public void eliminarRecinto(String idRecinto) {
        Recinto recinto = buscarPorId(idRecinto);
        if (recinto == null) {
            throw new IllegalArgumentException("No existe un recinto con ese id.");
        }

        recintoRepository.eliminar(idRecinto);

    }

    @Override
    public List<Recinto> consultarRecintos() {
        return recintoRepository.listar();
    }

    @Override
    public Recinto buscarPorId(String idRecinto) {
        if (idRecinto == null || idRecinto.isBlank()) {
            throw new IllegalArgumentException("El id es inválido.");
        }

        return recintoRepository.buscarPorId(idRecinto);
    }

    @Override
    public void asignarZona(String idRecinto, Zona zona) {
        Recinto recinto= buscarPorId(idRecinto);
        if (recinto == null) {
            throw new IllegalArgumentException("El recinto no existe.");
        }

        if (zona == null) {
            throw new IllegalArgumentException("La zona es nula.");
        }
        if (recinto.getZonas() == null) {
            recinto.setZonas(new java.util.ArrayList<>());
        }
        recinto.getZonas().add(zona);
        recintoRepository.actualizar(recinto);


    }

    @Override
    public void removerZona(String idRecinto, Zona zona) {
        Recinto recinto = buscarPorId(idRecinto);

        if (recinto == null) {
            throw new IllegalArgumentException("El recinto no existe.");
        }

        if (recinto.getZonas() == null) {
            recinto.setZonas(new java.util.ArrayList<>());
        }
        recinto.getZonas().remove(zona);

        recintoRepository.actualizar(recinto);

    }
    private void validarDatos(Recinto recinto) {

        if (recinto.getNombre() == null || recinto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }

        if (recinto.getDireccion() == null || recinto.getDireccion().isBlank()) {
            throw new IllegalArgumentException("La dirección es obligatoria.");
        }

        if (recinto.getCiudad() == null || recinto.getCiudad().isBlank()) {
            throw new IllegalArgumentException("La ciudad es obligatoria.");
        }
    }
}
