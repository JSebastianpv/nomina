package com.nomina.nomina.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovimientoDto {
    private int num_empleado;
    private int month;
    private int num_entregas;
}
