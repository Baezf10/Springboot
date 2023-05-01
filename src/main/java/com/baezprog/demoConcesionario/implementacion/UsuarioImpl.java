package com.baezprog.demoConcesionario.implementacion;

import com.baezprog.demoConcesionario.entity.Usuario;
import com.baezprog.demoConcesionario.repositorio.UsuarioRepository;
import com.baezprog.demoConcesionario.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImpl implements UsuarioServicio {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> encontrarTodos() {
        return this.usuarioRepository.findAll();
    }
    @Override
    public void crearUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }
    @Override
    public void actualizarUsuario(Usuario usuario) {
        if(usuario.getId()!=0){
            this.usuarioRepository.save(usuario);
        }
    }

    @Override
    public Usuario encontrarPorId(int id) {
        Usuario usuario=this.usuarioRepository.encontrarPorId(id);
        return usuario;
        //return this.usuarioRepository.encontrarPorId(id);
    }
    @Override
    public void eliminarUsuario(int id) {
        Usuario usuario=this.usuarioRepository.encontrarPorId(id);
        if (usuario!=null){
            this.usuarioRepository.delete(usuario);
        }
    }
}
