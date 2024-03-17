package com.nomina.nomina.repository;

import com.nomina.nomina.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM obtener_movimientos()")
    List<Movimiento> getMovimientos();

    @Query(nativeQuery = true, value = "SELECT * FROM obtener_movimientos_mes(:movMonth)")
    List<Movimiento> getMovimientoMes(@Param("movMonth") int movMonth);

    @Query(nativeQuery = true, value = "SELECT * FROM obtener_movimiento(:empMonth, :empId)")
    List<Movimiento> getMovimiento(@Param("empMonth") int empMonth,@Param("empId") int empId);

    @Query(nativeQuery = true, value = "SELECT guardar_movimiento(:mov_horas_trabajadas, :mov_month, :mov_numero_entregas, :mov_pago_bonos, :mov_pago_entregas, :mov_retencion, :mov_sueldo_total, :mov_vales, :mov_empleado_id)")
    void guardarMov(@Param("mov_horas_trabajadas") int movHorasT,
                    @Param("mov_month") int movMonth,
                    @Param("mov_numero_entregas") int movNoEntregas,
                    @Param("mov_pago_bonos") float movPagoBonos,
                    @Param("mov_pago_entregas") float movPagoEntregas,
                    @Param("mov_retencion") float movRetencion,
                    @Param("mov_sueldo_total") float movSueldo,
                    @Param("mov_vales") float movVales,
                    @Param("mov_empleado_id") int movEmpleadoId
                    );

    @Query(nativeQuery = true, value = "SELECT actualizar_movimiento(:mov_id, :mov_horas_trabajadas, :mov_month, :mov_numero_entregas, :mov_pago_bonos, :mov_pago_entregas, :mov_retencion, :mov_sueldo_total, :mov_vales, :mov_empleado_id)")
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
