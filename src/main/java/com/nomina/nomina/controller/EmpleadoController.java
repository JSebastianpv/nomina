package com.nomina.nomina.controller;

import com.nomina.nomina.dto.EmpleadoDto;
import com.nomina.nomina.model.Empleado;
import com.nomina.nomina.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class EmpleadoController {
    @Autowired
    EmpleadoService empServ;

    // Peticion GET para obtener los empleados
    @GetMapping("/empleado")
    public ResponseEntity<Object> get() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Empleado> list = empServ.getEmpleados();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Peticion GET para obtener un empleado por su numero de empleado
    @GetMapping("/empleado/num/{num_empleado}")
    public ResponseEntity<Object> get(@PathVariable int num_empleado) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Empleado> list = empServ.getEmpleado(num_empleado);
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Peticion GET para obtener un empleado por su numero id
    @GetMapping("/empleado/{idEmp}")
    public ResponseEntity<Object> getEmpId(@PathVariable int idEmp) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Empleado> list = empServ.getEmpleadoId(idEmp);
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Peticion POST para guardar empleado
    @PostMapping("/empleado")
    public ResponseEntity<Object> post(@RequestBody EmpleadoDto empDto) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            return empServ.guardarEmp(empDto.getNombre(), empDto.getApellido(), empDto.getNo_empleado(), empDto.getRol_id());
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Peticion PUT para actualizar el empleado
    @PutMapping("/empleado")
    public ResponseEntity<Object> put(@RequestBody EmpleadoDto empDto) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            return empServ.actualizaEmp(empDto.getId(), empDto.getNombre(), empDto.getApellido(), empDto.getNo_empleado(), empDto.getRol_id());
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
