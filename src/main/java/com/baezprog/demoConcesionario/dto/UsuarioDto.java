package com.baezprog.demoConcesionario.dto;

import lombok.Data;


import java.util.Date;

@Data
public class UsuarioDto {

    private int id;
    private Long identificacion;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String direccion;
    private Date fechaNacimiento;
    private String correo;
    private String clave;
}
