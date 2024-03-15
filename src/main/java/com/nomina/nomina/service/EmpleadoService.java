package com.nomina.nomina.service;

import com.nomina.nomina.model.Empleado;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpleadoService {
    public List<Empleado> getEmpleados();

    public List<Empleado> getEmpleado(int empNum);

    public ResponseEntity<Object> guardarEmp(String nombreEmp, String apellidoEmp, int noEmp, int rolEmp);

    public void actualizaEmp(int idEmp, String nombreEmp, String apellidoEmp, int noEmp, int rolEmp);
}
