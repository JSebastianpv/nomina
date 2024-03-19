package com.nomina.nomina.repository;

import com.nomina.nomina.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    // Funcion obtener_empleados de postgres para obtener todos los empleados
    @Query(nativeQuery = true, value = "SELECT * FROM obtener_empleados()")
    List<Empleado> getEmpleados();

    // Funcion obtener_empleado de postgres, recibe de parametro el no de empleado para obtener un empleado
    @Query(nativeQuery = true, value = "SELECT * FROM obtener_empleado(:emp_no_empleado)")
    List<Empleado> getEmpleado(@Param("emp_no_empleado") int numEmp);

    // Funcion obtener_empleado_id de postgres, recibe de parametro el id del empleado para obtenerlo
    @Query(nativeQuery = true, value = "SELECT * FROM obtener_empleado_id(:idEmp)")
    List<Empleado> getEmpleadoId(@Param("idEmp") int idEmp);

    // Funcion guardar_empleado de postgres, recibe de parametro nombre, apellido, no_empleado, rol_id para guardar el empleado
    @Query(nativeQuery = true, value = "SELECT guardar_empleado(:emp_nombre, :emp_apellido, :emp_no_empleado, :emp_rol_id)")
    void guardarEmp(@Param("emp_nombre") String nombreEmp,
                    @Param("emp_apellido") String apellidoEmp,
                    @Param("emp_no_empleado") int noEmp,
                    @Param("emp_rol_id") int rolEmp);

    // Funcion actualizar_empleado de postgres, recibe de parametro empleado_id, nombre, apellido, no_empleado, rol_id para actualizar el empleado
    @Query(nativeQuery = true, value = "SELECT actualizar_empleado(:emp_id, :emp_nombre, :emp_apellido, :emp_no_empleado, :emp_rol_id)")
    void actualizaEmp(@Param("emp_id") int idEmp,
                      @Param("emp_nombre") String nombreEmp,
                      @Param("emp_apellido") String apellidoEmp,
                      @Param("emp_no_empleado") int noEmp,
                      @Param("emp_rol_id") int rolEmp);
}
