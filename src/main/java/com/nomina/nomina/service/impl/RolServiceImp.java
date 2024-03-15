package com.nomina.nomina.service.impl;

import com.nomina.nomina.model.Rol;
import com.nomina.nomina.repository.RolRepository;
import com.nomina.nomina.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.List;

@Service
public class RolServiceImp implements RolService {

    @Autowired
    private RolRepository rolRep;

    @Override
    public List<Rol> getRoles() {
        return (List<Rol>) rolRep.getRoles();
    }

    @Override
    public void guardarRol(String rolNombre) {
        try {
            rolRep.guardarRol(rolNombre);
        } catch (Exception e) {
            throw new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void actualizarRol(int rolId, String rolNombre) {
        try {
            rolRep.actualizaRol(rolId, rolNombre);
        } catch (Exception e) {
            throw new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
