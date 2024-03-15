package com.nomina.nomina.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Empleado")
@Data
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "no_empleado")
    private int no_empleado;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
    //@OneToMany(mappedBy = "empleado")
    //private List<Movimiento> movimientos;
    @Column(name = "create_at")
    @CreatedDate
    private Date createAt;
}
