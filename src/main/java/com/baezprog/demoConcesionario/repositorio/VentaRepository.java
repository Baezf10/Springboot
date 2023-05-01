package com.baezprog.demoConcesionario.repositorio;


import com.baezprog.demoConcesionario.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VentaRepository extends JpaRepository<Venta,Integer> {
    @Query(value = "SELECT v FROM Venta v WHERE v.id=id")
    public Venta encontrarPorId(int id);
}
