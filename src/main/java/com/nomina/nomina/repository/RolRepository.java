package com.nomina.nomina.repository;

import com.nomina.nomina.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    // Funcion obtener_roles de postgres para obtener todos los roles
    @Query(nativeQuery = true, value = "SELECT * FROM obtener_roles()")
    List<Rol> getRoles();

    // Funcion obtener_rol_nombre de postgres para obtener roles con ese nombre
    @Query(nativeQuery = true, value = "SELECT * FROM obtener_rol_nombre(:rolNombre)")
    List<Rol> getRolNombre(@Param("rolNombre") String rolNombre);

    // Funcion obtener_rol de postgres para obtener un rol de acuerdo a su id
    @Query(nativeQuery = true, value = "SELECT * FROM obtener_rol(:rol_id)")
    List<Rol> getRol(@Param("rol_id") int rolId);

    // Funcion guardar_rol de postgres para guardar los roles
    @Query(nativeQuery = true, value = "SELECT guardar_rol(:rol_nombre, :rol_bono)")
    void guardarRol(@Param("rol_nombre") String nombreRol, @Param("rol_bono") float rolBono);

    // Funcion actualizar_rol de postgres para actualizar un rol
    @Query(nativeQuery = true, value = "SELECT actualizar_rol(:rol_id, :rol_nombre, :rol_bono)")
    void actualizaRol(@Param("rol_id") int rolId, @Param("rol_nombre") String rolNombre, @Param("rol_bono") float rolBono);
}
