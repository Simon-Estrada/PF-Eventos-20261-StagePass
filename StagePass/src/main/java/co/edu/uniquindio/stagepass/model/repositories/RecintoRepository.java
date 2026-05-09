package co.edu.uniquindio.stagepass.model.repositories;

import co.edu.uniquindio.stagepass.model.objects.Recinto;

import java.util.List;

public class RecintoRepository {
    private final List<Recinto> recintos;

    public RecintoRepository(List<Recinto> recintos) {
        this.recintos = recintos;
    }
    public Recinto guardar(Recinto recinto){
        recintos.add(recinto);
        return recinto;
    }
    public void actualizar(Recinto recinto){
        for(int i=0; i<recintos.size(); i++){
            Recinto enPosicion = recintos.get(i);
            if(enPosicion.getIdRecinto().equals(recinto.getIdRecinto())){
                recintos.set(i, recinto);
                return;
            }
        }
        throw new IllegalArgumentException("No hay un recinto con ese id.");
    }
    public void eliminar(String idRecinto){
        for(int i=0; i<recintos.size(); i++){
            Recinto enPosicion= recintos.get(i);
            if(enPosicion.getIdRecinto().equals(idRecinto)){
                recintos.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("No hay recinto con ese id.");
    }
    public Recinto buscarPorId(String idRecinto){
        for(Recinto recinto: recintos){
            if(recinto.getIdRecinto().equals(idRecinto)){
                return recinto;
            }
        }
        return null;
    }
    public List<Recinto> listar(){
        return recintos;
    }
}
