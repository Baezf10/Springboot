package com.baezprog.demoConcesionario.controlador;

import com.baezprog.demoConcesionario.negocio.UsuarioNegocio;
import com.baezprog.demoConcesionario.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path ="/usuario")
@CrossOrigin(value = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class UsuarioController {

    @Autowired
    private UsuarioNegocio usuarioNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){

        Map<String,Object> res= new HashMap<>();
        List<UsuarioDto> listDto=this.usuarioNegocio.encontrarTodos();
        res.put("status","ok");
        res.put("data",listDto);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearUsuario(@RequestBody Map<String,Object> request){

        Map<String,Object> res= new HashMap<>();
        UsuarioDto usuarioDto=new UsuarioDto();
        usuarioDto.setId(0);
        usuarioDto.setIdentificacion(Long.parseLong(request.get("identificacion").toString()));
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setTelefono(Long.parseLong(request.get("telefono").toString()));
        usuarioDto.setDireccion(request.get("direccion").toString());
        usuarioDto.setFechaNacimiento(new Date());
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setClave(request.get("clave").toString());

        String respuesta=this.usuarioNegocio.guardarUsuario(usuarioDto);
        res.put("status","ok");
        res.put("data",respuesta);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarUsuario(@RequestBody Map<String,Object> request){

        Map<String,Object> res=new HashMap<>();
        UsuarioDto usuarioDto=new UsuarioDto();
        usuarioDto.setId(Integer.parseInt(request.get("id").toString()));
        usuarioDto.setIdentificacion(Long.parseLong(request.get("identificacion").toString()));
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setTelefono(Long.parseLong(request.get("telefono").toString()));
        usuarioDto.setDireccion(request.get("direccion").toString());
        usuarioDto.setFechaNacimiento(new Date());
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setClave(request.get("clave").toString());

        String respuesta=this.usuarioNegocio.guardarUsuario(usuarioDto);
        res.put("status","ok");
        res.put("data",respuesta);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("id")int id){

        usuarioNegocio.eliminarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
