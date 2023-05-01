package com.baezprog.demoConcesionario.dto;

import lombok.Data;

@Data
public class ConcesionarioDto {

    private int id;
    private Long nit;
    private String nombreConcesionario;
    private String direccionConcesionario;
    private Long telefonoConcesionario;
    private String ciudad;
}
