package com.baezprog.demoConcesionario.dto;

import com.baezprog.demoConcesionario.entity.Usuario;
import com.baezprog.demoConcesionario.entity.Vehiculo;
import lombok.Data;

import java.util.Date;
@Data
public class VentaDto {
    private int id;
    private Date fechaVenta;
    private Long ValorTotal;
    private Vehiculo FK_idVehiculo;
    private Usuario FK_idUsuario;
}
