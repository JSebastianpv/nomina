package com.nomina.nomina.service.impl;

import com.nomina.nomina.model.Rol;
import com.nomina.nomina.repository.RolRepository;
import com.nomina.nomina.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RolServiceImp implements RolService {

    @Autowired
    private RolRepository rolRep;

    @Override
    public List<Rol> getRoles() {
        return (List<Rol>) rolRep.getRoles();
    }

    @Override
    public List<Rol> getRol(int rolId) {
        return (List<Rol>) rolRep.getRol(rolId);
    }

    @Override
    public List<Rol> getRolNombre(String rolNombre) {
        return rolRep.getRolNombre(rolNombre);
    }

    @Override
    public ResponseEntity<Object> guardarRol(String rolNombre, float rolBono) {
        try {
            Map<String, Object> body = new HashMap<>();
            List<Rol> rol = getRolNombre(rolNombre);
            if(!rol.isEmpty()) {
                System.out.println("Tiene un rol ya");
                body.put("error", "Ya existe un rol con ese nombre");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
            }
            System.out.println("Procede a crear");
            rolRep.guardarRol(rolNombre, rolBono);
            return ResponseEntity.ok("Rol Creado con Exito");
        } catch (Exception e) {
            throw new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void actualizarRol(int rolId, String rolNombre, float rolBono) {
        try {
            rolRep.actualizaRol(rolId, rolNombre, rolBono);
        } catch (Exception e) {
            throw new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
