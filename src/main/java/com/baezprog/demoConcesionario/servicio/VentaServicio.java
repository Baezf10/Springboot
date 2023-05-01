package com.baezprog.demoConcesionario.servicio;

import com.baezprog.demoConcesionario.entity.Venta;

import java.util.List;

public interface VentaServicio {
    public List<Venta> encontrarTodos();
    public Venta encontrarPorId(int id);
    public void actualizarVenta(Venta venta);
    public void crearVenta(Venta venta);
    public void eliminarVenta(int id);
}
