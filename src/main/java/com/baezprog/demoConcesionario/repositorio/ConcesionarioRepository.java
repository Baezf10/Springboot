package com.baezprog.demoConcesionario.repositorio;

import com.baezprog.demoConcesionario.entity.Concesionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcesionarioRepository extends JpaRepository<Concesionario,Integer> {
    @Query(value ="SELECT c FROM Concesionario c WHERE c.id=id")
    public Concesionario encontrarPorId(int id);
    @Query(value ="SELECT c.nit FROM Concesionario c")
    public List<Concesionario> findByNit();
}
