package com.baezprog.demoConcesionario.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", unique = true,length = 30, nullable = false)
    private String nombreRol;

    @Column(name = "descripcion", length = 100)
    private String descripcionRol;

    @ManyToMany(mappedBy = "listRoles")
    List<Usuario> listUsuarios;
}
