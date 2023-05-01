package com.baezprog.demoConcesionario.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ventas")
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaVenta", nullable = false)
    private Date fechaVenta;
    @Column(name = "ValorTotal", nullable = false)
    private Long ValorTotal;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo FK_idVehiculo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario FK_idUsuario;

}
