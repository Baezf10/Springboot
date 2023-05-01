package com.baezprog.demoConcesionario.implementacion;

import com.baezprog.demoConcesionario.entity.Vehiculo;
import com.baezprog.demoConcesionario.repositorio.VehiculoRepository;
import com.baezprog.demoConcesionario.servicio.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoImpl implements VehiculoServicio {
    @Autowired
    VehiculoRepository vehiculoRepository;
    @Override
    public List<Vehiculo> encontrarTodos() {
        return this.vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo encontrarPorId(int id) {
        Vehiculo vehiculo=this.vehiculoRepository.encontrarPorId(id);
        return vehiculo;
        //return this.vehiculoRepository.encontrarPorId(id);
    }

    @Override
    public void actualizarVehiculo(Vehiculo vehiculo) {
        if (vehiculo.getId()!=0) {
            this.vehiculoRepository.save(vehiculo);
        }
    }

    @Override
    public void crearVehiculo(Vehiculo vehiculo) {
        this.vehiculoRepository.save(vehiculo);
    }

    @Override
    public void eliminarVehiculo(int id) {
        Vehiculo vehiculo=this.vehiculoRepository.encontrarPorId(id);
        if (vehiculo!=null){
            this.vehiculoRepository.delete(vehiculo);
        }
    }
}
