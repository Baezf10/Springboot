package com.baezprog.demoConcesionario.negocio;

import com.baezprog.demoConcesionario.dto.VehiculoDto;
import com.baezprog.demoConcesionario.entity.Vehiculo;
import com.baezprog.demoConcesionario.implementacion.VehiculoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehiculoNegocio {
    @Autowired
    private VehiculoImpl vehiculoImpl;

    private List<VehiculoDto> listVehiculosDto;

    public List<VehiculoDto> encontrarTodos() {
        listVehiculosDto = new ArrayList<>();
        this.vehiculoImpl.encontrarTodos().forEach(vehiculo->{
            VehiculoDto vehiculoDto = new VehiculoDto();
            vehiculoDto.setId(vehiculo.getId());
            vehiculoDto.setPlaca(vehiculo.getPlaca());
            vehiculoDto.setPrecio(vehiculo.getPrecio());
            vehiculoDto.setTipoVehiculo(vehiculo.getTipoVehiculo());
            vehiculoDto.setMarca(vehiculo.getMarca());
            vehiculoDto.setModelo(vehiculo.getModelo());
            vehiculoDto.setColor(vehiculo.getColor());
            vehiculoDto.setAnho(vehiculo.getAnho());
            //vehiculoDto.getFK_idConcesionario(vehiculo.getFK_idConcesionario());
            this.listVehiculosDto.add(vehiculoDto);
        });
        return this.listVehiculosDto;
    }
    public String guardarVehiculo(VehiculoDto vehiculoDto){
        Vehiculo vehiculo=new Vehiculo();
        try{
            if(vehiculoDto.getId()!=0) {
                vehiculo.setId(vehiculoDto.getId());
                vehiculo.setPlaca(vehiculoDto.getPlaca());
                vehiculo.setPrecio(vehiculoDto.getPrecio());
                vehiculo.setTipoVehiculo(vehiculoDto.getTipoVehiculo());
                vehiculo.setMarca(vehiculoDto.getMarca());
                vehiculo.setModelo(vehiculoDto.getModelo());
                vehiculo.setColor(vehiculoDto.getColor());
                vehiculo.setAnho(vehiculoDto.getAnho());
                vehiculo.setFK_idConcesionario(vehiculoDto.getFK_idConcesionario());

                this.vehiculoImpl.actualizarVehiculo(vehiculo);
            }else{
                //vehiculo.setId(vehiculoDto.getId());
                vehiculo.setPlaca(vehiculoDto.getPlaca());
                vehiculo.setPrecio(vehiculoDto.getPrecio());
                vehiculo.setTipoVehiculo(vehiculoDto.getTipoVehiculo());
                vehiculo.setMarca(vehiculoDto.getMarca());
                vehiculo.setModelo(vehiculoDto.getModelo());
                vehiculo.setColor(vehiculoDto.getColor());
                vehiculo.setAnho(vehiculoDto.getAnho());
                vehiculo.setFK_idConcesionario(vehiculoDto.getFK_idConcesionario());

                this.vehiculoImpl.crearVehiculo(vehiculo);
            }
            return "Se guardaron correctamente";
        }catch (Exception e){
            return "Fallo algo";
        }
    }
}
