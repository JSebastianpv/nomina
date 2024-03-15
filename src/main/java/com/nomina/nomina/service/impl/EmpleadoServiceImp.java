package com.nomina.nomina.service.impl;

import com.nomina.nomina.model.Empleado;
import com.nomina.nomina.repository.EmpleadoRepository;
import com.nomina.nomina.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpleadoServiceImp implements EmpleadoService {
    @Autowired
    private EmpleadoRepository empRep;

    @Override
    public List<Empleado> getEmpleados() {
        return (List<Empleado>) empRep.getEmpleados();
    }

    @Override
    public List<Empleado> getEmpleado(int numEmp) {
        return (List<Empleado>) empRep.getEmpleado(numEmp);
    }

    @Override
    public ResponseEntity<Object> guardarEmp(String nombreEmp, String apellidoEmp, int noEmp, int rolEmp) {
        try {
            Map<String, Object> body = new HashMap<>();
            body.put("message", "Ya existe un empleado con ese numero de emplado");
            // Valido si existe el empleado con ese numero de empleado
            List<Empleado> empleado = getEmpleado(noEmp);
            if(!empleado.isEmpty()) {
                return ResponseEntity.status(401).body(body);
            }

            empRep.guardarEmp(nombreEmp, apellidoEmp, noEmp, rolEmp);
            return ResponseEntity.ok("Empleado Creado con Exito");
        } catch (Exception e) {
            throw new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void actualizaEmp(int idEmp, String nombreEmp, String apellidoEmp, int noEmp, int rolEmp) {
        try {
            empRep.actualizaEmp(idEmp, nombreEmp, apellidoEmp, noEmp, rolEmp);
        } catch (Exception e) {
            throw new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
