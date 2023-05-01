package com.baezprog.demoConcesionario.dto;

import com.baezprog.demoConcesionario.entity.Concesionario;
import lombok.Data;

@Data
public class VehiculoDto {
    private int id;
    private String placa;
    private Long precio;
    private String tipoVehiculo;
    private String marca;
    private String modelo;
    private String color;
    private int anho;

   private Concesionario FK_idConcesionario;
}
