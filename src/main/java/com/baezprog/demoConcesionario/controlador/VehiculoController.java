package com.baezprog.demoConcesionario.controlador;

import com.baezprog.demoConcesionario.dto.VehiculoDto;
import com.baezprog.demoConcesionario.negocio.VehiculoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path ="/vehiculo")
@CrossOrigin(value = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class VehiculoController {
    @Autowired
    private VehiculoNegocio vehiculoNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){

        Map<String, Object> res=new HashMap<>();
        List<VehiculoDto> listDto=this.vehiculoNegocio.encontrarTodos();
        res.put("status","ok");
        res.put("status",listDto);

        return  new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearVehiculo(@RequestBody Map<String,Object> request){

        Map<String,Object> res= new HashMap<>();
        VehiculoDto vehiculoDto=new VehiculoDto();
        vehiculoDto.setId(0);
        vehiculoDto.setPlaca(request.get("placa").toString());
        vehiculoDto.setPrecio(Long.parseLong(request.get("precio").toString()));
        vehiculoDto.setTipoVehiculo(request.get("tipoVehiculo").toString());
        vehiculoDto.setMarca(request.get("marca").toString());
        vehiculoDto.setModelo(request.get("modelo").toString());
        vehiculoDto.setColor(request.get("color").toString());
        vehiculoDto.setAnho(Integer.parseInt(request.get("anho").toString()));
        //vehiculoDto.setFK_idConcesionario(Integer.parseInt(request.get("FK_idConcesionario").toString()));
        //vehiculoDto.setFK_idMarca(Integer.parseInt(request.get("FK_idMarca").toString()));

        String respuesta=this.vehiculoNegocio.guardarVehiculo(vehiculoDto);
        res.put("status","ok");
        res.put("data",respuesta);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarVehiculo(@RequestBody Map<String,Object> request){
        Map<String,Object> res= new HashMap<>();
        VehiculoDto vehiculoDto=new VehiculoDto();
        vehiculoDto.setId(Integer.parseInt(request.get("id").toString()));
        vehiculoDto.setPlaca(request.get("placa").toString());
        vehiculoDto.setPrecio(Long.parseLong(request.get("precio").toString()));
        vehiculoDto.setTipoVehiculo(request.get("tipoVehiculo").toString());
        vehiculoDto.setMarca(request.get("marca").toString());;
        vehiculoDto.setModelo(request.get("modelo").toString());
        vehiculoDto.setColor(request.get("color").toString());
        vehiculoDto.setAnho(Integer.parseInt(request.get("anho").toString()));

        //vehiculoDto.setFK_idConcesionario(Integer.parseInt(request.get("FK_idConcesionario").toString()));
        //vehiculoDto.setFK_idMarca(Integer.parseInt(request.get("FK_idMarca").toString()));

        String respuesta=this.vehiculoNegocio.guardarVehiculo(vehiculoDto);
        res.put("status","ok");
        res.put("data",respuesta);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }


}
