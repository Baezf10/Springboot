package com.baezprog.demoConcesionario.negocio;

import com.baezprog.demoConcesionario.entity.Venta;
import com.baezprog.demoConcesionario.dto.VentaDto;
import com.baezprog.demoConcesionario.implementacion.VentaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class VentaNegocio {
    @Autowired
    private VentaImpl ventaImpl;

    private List<VentaDto> listVentasDto;

    public List<VentaDto> encontrarTodos(){
        listVentasDto=new ArrayList<>();
        this.ventaImpl.encontrarTodos().forEach(venta->{

            VentaDto ventaDto=new VentaDto();

            ventaDto.setId(venta.getId());
            ventaDto.setFechaVenta(venta.getFechaVenta());
            ventaDto.setValorTotal(venta.getValorTotal());
            ventaDto.setFK_idVehiculo(venta.getFK_idVehiculo());
            //ventaDto.setFK_idUsuario(venta.setFK_idUsuario());
            this.listVentasDto.add(ventaDto);
        });
        return this.listVentasDto;
    }

    public String guardarVenta(VentaDto ventaDto){
        Venta venta=new Venta();
        try {
            if (ventaDto.getId()!=0){
                venta.setId(ventaDto.getId());
                venta.setFechaVenta(ventaDto.getFechaVenta());
                venta.setValorTotal(ventaDto.getValorTotal());
                venta.setFK_idVehiculo(ventaDto.getFK_idVehiculo());
                venta.setFK_idUsuario(ventaDto.getFK_idUsuario());
                this.ventaImpl.actualizarVenta(venta);
            }
            else {
                //venta.setId(ventaDto.getId());
                venta.setFechaVenta(ventaDto.getFechaVenta());
                venta.setValorTotal(ventaDto.getValorTotal());
                venta.setFK_idVehiculo(ventaDto.getFK_idVehiculo());
                venta.setFK_idUsuario(ventaDto.getFK_idUsuario());
                this.ventaImpl.crearVenta(venta);
            }
            return "Se guardaron correctamente";
        }catch(Exception e){
            return "Fallo algo";
        }
    }
}
