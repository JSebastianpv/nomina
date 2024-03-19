package com.nomina.nomina.service;

import com.nomina.nomina.model.Rol;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolService {

    public List<Rol> getRoles();

    public List<Rol> getRol(int rolId);

    public List<Rol> getRolNombre(String rolNombre);

    public ResponseEntity<Object> guardarRol(String rolNombre, float bono);

    public void actualizarRol(int rolId, String rolNombre, float rolBono);
}
