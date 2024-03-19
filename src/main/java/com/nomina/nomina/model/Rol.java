package com.nomina.nomina.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Rol")
@Data
public class Rol implements Serializable {
    // Aqui creo la estructura de mi tabla o entidad Rol
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "bono")
    private float bono;
}
