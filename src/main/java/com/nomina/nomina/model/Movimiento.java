package com.nomina.nomina.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "Movimiento")
@Data
public class Movimiento implements Serializable {
    // Aqui creo la estructura de mi tabla o entidad Movimiento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "month")
    private int month;
    @Column(name = "horas_trabajadas")
    private int horas_trabajadas;
    @Column(name = "numero_entregas")
    private int numero_entregas;
    @Column(name = "pago_entregas")
    private float pago_entregas;
    @Column(name = "pago_bonos")
    private float pago_bonos;
    @Column(name = "retencion")
    private float retencion;
    @Column(name = "vales")
    private float vales;
    @Column(name = "sueldo_total")
    private float sueldo_total;
    @Column(name = "bono_hora")
    private float bono_hora;
    @Column(name = "nombre_rol")
    private String nombre_rol;
    @Column(name = "sueldo_base")
    private float sueldo_base;
    @Column(name = "num_faltas")
    private int num_faltas;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;


}
