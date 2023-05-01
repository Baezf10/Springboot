package com.baezprog.demoConcesionario.controlador;

import com.baezprog.demoConcesionario.dto.ConcesionarioDto;
import com.baezprog.demoConcesionario.negocio.ConcesionarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path ="/concesionario")
@CrossOrigin(value = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class ConcesionarioController {
    @Autowired
    private ConcesionarioNegocio concesionarioNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){
        Map<String,Object> res=new HashMap<>();
        List<ConcesionarioDto> listDto=this.concesionarioNegocio.encontrarTodos();
        res.put("status","ok");
        res.put("data:",listDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearConcesionario(@RequestBody Map<String,Object> request){
    Map<String,Object> res=new HashMap<>();
    ConcesionarioDto concesionarioDto=new ConcesionarioDto();
    concesionarioDto.setId(0);
    concesionarioDto.setNit(Long.parseLong(request.get("nit").toString()));
    concesionarioDto.setNombreConcesionario(request.get("nombreConcesionario").toString());
    concesionarioDto.setDireccionConcesionario(request.get("direccionConcesionario").toString());
    concesionarioDto.setTelefonoConcesionario(Long.parseLong(request.get("telefonoConcesionario").toString()));
    concesionarioDto.setCiudad(request.get("ciudad").toString());
    //concesionarioDto.setFK_idCiudad(Integer.parseInt(request.get("FK_idCiudad").toString()));

        String respuesta=this.concesionarioNegocio.guardarConcesionario(concesionarioDto);
        res.put("status","ok");
        res.put("data:",respuesta);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarConcesionario(@RequestBody Map<String,Object> request){
        Map<String,Object> res=new HashMap<>();
        ConcesionarioDto concesionarioDto=new ConcesionarioDto();
        concesionarioDto.setId(Integer.parseInt(request.get("id").toString()));
        concesionarioDto.setNit(Long.parseLong(request.get("nit").toString()));
        concesionarioDto.setNombreConcesionario(request.get("nombreConcesionario").toString());
        concesionarioDto.setDireccionConcesionario(request.get("direccionConcesionario").toString());
        concesionarioDto.setTelefonoConcesionario(Long.parseLong(request.get("telefonoConcesionario").toString()));
        concesionarioDto.setCiudad(request.get("ciudad").toString());        //concesionarioDto.setFK_idCiudad(Integer.parseInt(request.get("FK_idCiudad").toString()));
        String respuesta=this.concesionarioNegocio.guardarConcesionario(concesionarioDto);
        res.put("status","ok");
        res.put("data:",respuesta);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
