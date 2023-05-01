package com.baezprog.demoConcesionario.implementacion;

import com.baezprog.demoConcesionario.entity.Concesionario;
import com.baezprog.demoConcesionario.repositorio.ConcesionarioRepository;
import com.baezprog.demoConcesionario.servicio.ConcesionarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcesionarioImpl implements ConcesionarioServicio {

    @Autowired
    ConcesionarioRepository concesionarioRepository;
    @Override
    public List<Concesionario> encontrarTodos() {
        return this.concesionarioRepository.findAll();
    }
    @Override
    public void crearConcesionario(Concesionario concesionario) {
        this.concesionarioRepository.save(concesionario);
    }
    @Override
    public void actualizarConcesionario(Concesionario concesionario) {
        if(concesionario.getId()!=0){
            this.concesionarioRepository.save(concesionario);
        }
    }
    @Override
    public Concesionario encontrarPorId(int id) {
        Concesionario concesionario = this.concesionarioRepository.encontrarPorId(id);
        return concesionario;
    }

    @Override
    public void eliminarConcesionario(int id) {
        Concesionario concesionario=this.concesionarioRepository.encontrarPorId(id);
        if (concesionario!=null){
            this.concesionarioRepository.delete(concesionario);
        }
    }
}
