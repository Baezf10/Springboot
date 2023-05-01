package com.baezprog.demoConcesionario.implementacion;

import com.baezprog.demoConcesionario.entity.Venta;
import com.baezprog.demoConcesionario.repositorio.VentaRepository;
import com.baezprog.demoConcesionario.servicio.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaImpl implements VentaServicio {
    @Autowired
    VentaRepository ventaRepository;
    @Override
    public List<Venta> encontrarTodos() {
        return this.ventaRepository.findAll();
    }
    @Override
    public void crearVenta(Venta venta) {
        this.ventaRepository.save(venta);
    }
    @Override
    public void actualizarVenta(Venta venta) {
        if (venta.getId()!=0) {
            this.ventaRepository.save(venta);
        }
    }
    @Override
    public Venta encontrarPorId(int id) {
        Venta venta = this.ventaRepository.encontrarPorId(id);
        return venta;
    }





    @Override
    public void eliminarVenta(int id) {
        Venta venta=this.ventaRepository.encontrarPorId(id);
        if (venta!=null){
            this.ventaRepository.delete(venta);
        }
    }
}
