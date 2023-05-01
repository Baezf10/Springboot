package com.baezprog.demoConcesionario.servicio;

import com.baezprog.demoConcesionario.entity.Usuario;

import java.util.List;

public interface UsuarioServicio {
    public List<Usuario> encontrarTodos();
    public Usuario encontrarPorId(int id);
    public void actualizarUsuario(Usuario usuario);
    public void crearUsuario(Usuario usuario);
    public void eliminarUsuario(int id);
}
