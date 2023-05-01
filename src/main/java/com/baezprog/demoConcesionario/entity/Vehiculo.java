package com.baezprog.demoConcesionario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "vehiculos")
@Data
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "placa", length = 6, unique = true, nullable = false)
    private String placa;
    @Column(name = "precio", nullable = false)
    private Long precio;
    @Column(name = "tipo_vehiculo", length = 50, nullable = false)
    private String tipoVehiculo;
    @Column(name = "marca", length = 50, nullable = false)
    private String marca;

    @Column(name = "modelo",length=50, nullable = false)
    private String modelo;
    @Column(name = "color",length=20, nullable = false)
    private String color;
    @Column(name = "anho", length = 4, nullable = false)
    private int anho;

    @ManyToOne
    @JoinColumn(name = "concesionario_id")
    private Concesionario FK_idConcesionario;

    @JsonIgnore
    @OneToMany(mappedBy = "FK_idVehiculo")
    private List<Venta> listVenta;

}