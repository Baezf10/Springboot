package com.baezprog.demoConcesionario.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "concesionarios")
@Data
public class Concesionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nit", length = 9,unique = true, nullable = false)
    private Long nit;
    @Column(name = "nombre",length = 50, nullable = false)
    private String nombreConcesionario;

    @Column(name = "direccion", length = 75, nullable = false)
    private String direccionConcesionario;
    @Column(name = "telefono", length = 10, nullable = false)
    private Long telefonoConcesionario;

    @Column(name = "ciudad", length = 50, nullable = false)
    private String ciudad;

    @JsonIgnore
    @OneToMany(mappedBy = "FK_idConcesionario")
    private List<Vehiculo> listVehiculo;

}