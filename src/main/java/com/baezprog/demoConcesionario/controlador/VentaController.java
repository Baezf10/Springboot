package com.baezprog.demoConcesionario.controlador;

import com.baezprog.demoConcesionario.dto.VentaDto;

import com.baezprog.demoConcesionario.negocio.VentaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path ="/venta")
@CrossOrigin(value = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class VentaController {
    @Autowired
    private VentaNegocio ventaNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all() {
        Map<String,Object> res= new HashMap<>();
        List<VentaDto> listDto=this.ventaNegocio.encontrarTodos();
        res.put("status", "ok");
        res.put("data", listDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

     @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearVenta(@RequestBody Map<String,Object> request){
        Map<String, Object> res =new HashMap<>();
        VentaDto ventaDto=new VentaDto();
        ventaDto.setId(Integer.parseInt(request.get("id").toString()));
        ventaDto.setFechaVenta(new Date());
        ventaDto.setValorTotal(Long.parseLong(request.get("valorTotal").toString()));
        //Falta Vehiculo
         //Falta usuario
         String respuesta=this.ventaNegocio.guardarVenta(ventaDto);
         res.put("status","ok");
         res.put("data",respuesta);

         return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarVenta(@RequestBody Map<String,Object> request){
        Map<String, Object> res =new HashMap<>();
        VentaDto ventaDto=new VentaDto();
        ventaDto.setId(Integer.parseInt(request.get("id").toString()));
        ventaDto.setFechaVenta(new Date());
        ventaDto.setValorTotal(Long.parseLong(request.get("valorTotal").toString()));
        //Falta Vehiculo
        //Falta usuario
        String respuesta=this.ventaNegocio.guardarVenta(ventaDto);
        res.put("status","ok");
        res.put("data",respuesta);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
