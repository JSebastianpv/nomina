package com.nomina.nomina.controller;

import com.nomina.nomina.dto.RolDto;
import com.nomina.nomina.model.Rol;
import com.nomina.nomina.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class RolController {
    @Autowired
    RolService rolServ;

    @GetMapping("/rol")
    public ResponseEntity<Object> get() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Rol> list = rolServ.getRoles();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/rol/{rolId}")
    public ResponseEntity<Object> get(@PathVariable int rolId) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Rol> list = rolServ.getRol(rolId);
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/rol")
    public ResponseEntity<Object> post(@RequestBody RolDto rolDto) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            rolServ.guardarRol(rolDto.getNombre(), rolDto.getBono());
            return ResponseEntity.ok("Rol Creado con Exito");
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/rol")
    public ResponseEntity<Object> put(@RequestBody RolDto rolDto) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            rolServ.actualizarRol(rolDto.getId(), rolDto.getNombre(), rolDto.getBono());
            return ResponseEntity.ok("Rol Actualizado con Exito");
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
