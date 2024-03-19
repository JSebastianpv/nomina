package com.nomina.nomina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolDto {
    // Utilizo el dto para encapsular los datos y transferirlos a otros componentes
    private int id;
    private String nombre;
    private float bono;
}
