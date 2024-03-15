package com.nomina.nomina.service;

import com.nomina.nomina.model.Rol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolService {

    public List<Rol> getRoles();

    public void guardarRol(String rolNombre);

    public void actualizarRol(int rolId, String rolNombre);
}
