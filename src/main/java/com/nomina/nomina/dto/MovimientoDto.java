package com.nomina.nomina.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovimientoDto {
    // Utilizo el dto para encapsular los datos y transferirlos a otros componentes
    private int num_empleado;
    private int month;
    private int num_entregas;
    private int num_faltas;
}
