package com.nomina.nomina.controller;

import com.nomina.nomina.dto.MovimientoDto;
import com.nomina.nomina.model.Movimiento;
import com.nomina.nomina.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class MovimientoController {

    @Autowired
    MovimientoService movServ;
    // Peticion POST para guardar mi movimiento
    @PostMapping("/movimiento")
    public ResponseEntity<Object> post(@RequestBody MovimientoDto movDto) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // Retorno lo que me responde mi servicio en la funcion de guardarMov
            return movServ.guardarMov(movDto.getMonth(), movDto.getNum_entregas(), movDto.getNum_empleado(), movDto.getNum_faltas());
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Peticion GET para obtener los movimientos
    @GetMapping("/movimiento")
    public ResponseEntity<Object> get() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Movimiento> list = movServ.getMovimientos();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Peticion GET para obtener los movimientos por mes
    @GetMapping("/movimiento/{movMonth}")
    public ResponseEntity<Object> get(@PathVariable int movMonth) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Movimiento> list = movServ.getMovimientoMes(movMonth);
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Peticion GET para obtener el movimiento por id
    @GetMapping("/movimiento/mov/{movId}")
    public ResponseEntity<Object> getMovId(@PathVariable int movId) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Movimiento> list = movServ.getMovimientoId(movId);
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
