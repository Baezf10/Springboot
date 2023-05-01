package com.baezprog.demoConcesionario.repositorio;

import com.baezprog.demoConcesionario.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Integer> {
    @Query(value = "SELECT v FROM Vehiculo v WHERE v.id=id")
    public Vehiculo encontrarPorId(int id);

    @Query(value = "SELECT v.placa FROM Vehiculo v")
    public List<Vehiculo> findByPlaca();
}