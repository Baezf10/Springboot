package com.baezprog.demoConcesionario.negocio;

import com.baezprog.demoConcesionario.dto.UsuarioDto;
import com.baezprog.demoConcesionario.entity.Usuario;
import com.baezprog.demoConcesionario.implementacion.UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class UsuarioNegocio {

    @Autowired
    private UsuarioImpl usuarioImpl;

    private List<UsuarioDto> listUsuariosDto;

    public List<UsuarioDto> encontrarTodos(){
        listUsuariosDto= new ArrayList<>();
        this.usuarioImpl.encontrarTodos().forEach(usuario->{

            UsuarioDto usuarioDto=new UsuarioDto();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setIdentificacion(usuario.getIdentificacion());
            usuarioDto.setNombre(usuario.getNombre());
            usuarioDto.setApellido(usuario.getApellido());
            usuarioDto.setTelefono(usuario.getTelefono());
            usuarioDto.setDireccion(usuario.getDireccion());
            usuarioDto.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioDto.setCorreo(usuario.getCorreo());
            usuarioDto.setClave(usuario.getClave());
            this.listUsuariosDto.add(usuarioDto);
        });
        return this.listUsuariosDto;
    }

    public String guardarUsuario(UsuarioDto usuarioDto){
        Usuario usuario=new Usuario();
        try{
            if (usuarioDto.getId()!=0){
                usuario.setId(usuarioDto.getId());
                usuario.setIdentificacion(usuarioDto.getIdentificacion());
                usuario.setNombre(usuarioDto.getNombre());
                usuario.setApellido(usuarioDto.getApellido());
                usuario.setTelefono(usuarioDto.getTelefono());
                usuario.setDireccion(usuarioDto.getDireccion());
                usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
                usuario.setCorreo(usuarioDto.getCorreo());
                usuario.setClave(usuarioDto.getClave());
                this.usuarioImpl.actualizarUsuario(usuario);
            }
            else{
                //usuarioDto.setId(usuarioDto.getId());
                usuario.setIdentificacion(usuarioDto.getIdentificacion());
                usuario.setNombre(usuarioDto.getNombre());
                usuario.setApellido(usuarioDto.getApellido());
                usuario.setTelefono(usuarioDto.getTelefono());
                usuario.setDireccion(usuarioDto.getDireccion());
                usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
                usuario.setCorreo(usuarioDto.getCorreo());
                usuario.setClave(usuarioDto.getClave());
                this.usuarioImpl.crearUsuario(usuario);
            }
            return "Se guardaron correctamente";
        }catch (Exception e){
            return "Fallo algo";
        }

    }
    public String eliminarUsuario(int id){
        Usuario usuario=new Usuario();
        try {
            usuarioImpl.eliminarUsuario(id);
            return "Se elimino correctamente";
        }catch (Exception e){
            return "Fallo algo";
        }
    }
}
