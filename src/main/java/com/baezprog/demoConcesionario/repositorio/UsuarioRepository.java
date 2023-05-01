package com.baezprog.demoConcesionario.repositorio;

import com.baezprog.demoConcesionario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value ="SELECT u FROM Usuario u WHERE u.id=id")
    public Usuario encontrarPorId(int id);

    @Query(value ="SELECT u.identificacion FROM Usuario u")
    public List<Usuario> findByIdn();

    @Query(value ="DELETE Usuario u WHERE u.id=id")
    public void eliminarUsuario(int id);
}
