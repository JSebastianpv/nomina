package com.nomina.nomina.controller;

import com.nomina.nomina.dto.MovimientoDto;
import com.nomina.nomina.model.Movimiento;
import com.nomina.nomina.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MovimientoController {

    @Autowired
    MovimientoService movServ;
    @PostMapping("/movimiento")
    public ResponseEntity<Object> post(@RequestBody MovimientoDto movDto) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // Retorno lo que me responde mi servicio en la funcion de guardarMov
            return movServ.guardarMov(movDto.getMonth(), movDto.getNum_entregas(), movDto.getNum_empleado());
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
}
