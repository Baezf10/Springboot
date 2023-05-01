package com.baezprog.demoConcesionario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "identificacion", unique = true, nullable = false)
    private Long identificacion;
    @Column(name = "nombre", length=50, nullable = false)
    private String nombre;
    @Column(name = "apellido", length=50, nullable = false)
    private String apellido;
    @Column(name = "telefono", length=10, nullable = false)
    private Long telefono;
    @Column(name = "direccion", length=75, nullable = false)
    private String direccion;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;
    @Column(name = "correo", length=50, unique = true, nullable = false)
    private String correo;
    @Column(name = "clave", length=50, nullable = false)
    private String clave;

    @JsonIgnore
    @OneToMany(mappedBy = "FK_idUsuario")
    private List<Venta> listVenta;

    @ManyToMany
    @JoinTable(name = "Usuario_has_Roles",
            joinColumns=@JoinColumn(name="FK_idRol"),
            inverseJoinColumns=@JoinColumn(name="FK_idUsuario")
    )
    private List<Rol>listRoles;
}
