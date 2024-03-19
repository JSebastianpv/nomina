package com.nomina.nomina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoDto {
    // Utilizo el dto para encapsular los datos y transferirlos a otros componentes
    private int id;
    private String nombre;
    private String apellido;
    private int no_empleado;
    private int rol_id;
}
