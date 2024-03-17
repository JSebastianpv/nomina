package com.nomina.nomina.repository;

import com.nomina.nomina.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM obtener_roles()")
    List<Rol> getRoles();

    @Query(nativeQuery = true, value = "SELECT * FROM obtener_rol(:rol_id)")
    List<Rol> getRol(@Param("rol_id") int rolId);

    @Query(nativeQuery = true, value = "SELECT guardar_rol(:rol_nombre, :rol_bono)")
    void guardarRol(@Param("rol_nombre") String nombreRol, @Param("rol_bono") float rolBono);

    @Query(nativeQuery = true, value = "SELECT actualizar_rol(:rol_id, :rol_nombre, :rol_bono)")
    void actualizaRol(@Param("rol_id") int rolId, @Param("rol_nombre") String rolNombre, @Param("rol_bono") float rolBono);
}
