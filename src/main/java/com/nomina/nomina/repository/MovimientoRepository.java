package com.nomina.nomina.repository;

import com.nomina.nomina.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

    // Funcion obtener_empleados de postgres para obtener todos los empleados
    @Query(nativeQuery = true, value = "SELECT * FROM obtener_movimientos()")
    List<Movimiento> getMovimientos();

    // Funcion obtener_movimientos_mes de postgres, recibe de parametro el no de mes para
    @Query(nativeQuery = true, value = "SELECT * FROM obtener_movimientos_mes(:movMonth)")
    List<Movimiento> getMovimientoMes(@Param("movMonth") int movMonth);

    // Funcion obtener_movimiento de postgres, para obtener movimientos de un empleado en ese mes
    @Query(nativeQuery = true, value = "SELECT * FROM obtener_movimiento(:empMonth, :empId)")
    List<Movimiento> getMovimiento(@Param("empMonth") int empMonth,@Param("empId") int empId);

    // Funcion obtener_movimientoId de postgres, recibe de parametro el id del movto, para mostrar solo ese registro
    @Query(nativeQuery = true, value = "SELECT * FROM obtener_movimientoId(:movId)")
    List<Movimiento> getMovimientoId(@Param("movId") int movId);

    // Funcion guardar_movimiento de postgres, esta funcion es para hacer el guardado de los datos del movimiento, cada valor ya fue calculado
    @Query(nativeQuery = true, value = "SELECT guardar_movimiento(:mov_horas_trabajadas, " +
                         ":mov_month, " +
                        ":mov_numero_entregas, " +
                        ":mov_pago_bonos, " +
                        ":mov_pago_entregas, " +
                        ":mov_retencion, " +
                        ":mov_sueldo_total, " +
                        ":mov_vales, " +
                        ":mov_empleado_id, " +
                        ":mov_bono_hora, " +
                        ":mov_nombre_rol, " +
                        ":mov_sueldo_base, " +
                        ":num_faltas)")
    void guardarMov(@Param("mov_horas_trabajadas") int movHorasT,
                    @Param("mov_month") int movMonth,
                    @Param("mov_numero_entregas") int movNoEntregas,
                    @Param("mov_pago_bonos") float movPagoBonos,
                    @Param("mov_pago_entregas") float movPagoEntregas,
                    @Param("mov_retencion") float movRetencion,
                    @Param("mov_sueldo_total") float movSueldo,
                    @Param("mov_vales") float movVales,
                    @Param("mov_empleado_id") int movEmpleadoId,
                    @Param("mov_bono_hora") float mov_bono_hora,
                    @Param("mov_nombre_rol") String mov_nombre_rol,
                    @Param("mov_sueldo_base") float mov_sueldo_base,
                    @Param("num_faltas") int num_faltas

                    );

    // Funcion actualizar_movimiento de postgres para actualizar un movimiento, pendiente...
    @Query(nativeQuery = true, value = "SELECT actualizar_movimiento(:mov_id, " +
                            ":mov_horas_trabajadas, " +
                            ":mov_month, " +
                            ":mov_numero_entregas, " +
                            ":mov_pago_bonos, " +
                            ":mov_pago_entregas, " +
                            ":mov_retencion, " +
                            ":mov_sueldo_total, " +
                            ":mov_vales, " +
                            ":mov_empleado_id)")
    void actualizaMov(@Param("mov_id") int movId,
                      @Param("mov_horas_trabajadas") int movHorasT,
                      @Param("mov_month") int movMonth,
                      @Param("mov_numero_entregas") int movNoEntregas,
                      @Param("mov_pago_bonos") float movPagoBonos,
                      @Param("mov_pago_entregas") float movPagoEntregas,
                      @Param("mov_retencion") float movRetencion,
                      @Param("mov_sueldo_total") float movSueldo,
                      @Param("mov_vales") float movVales,
                      @Param("mov_empleado_id") int movEmpleadoId
                    );
}
