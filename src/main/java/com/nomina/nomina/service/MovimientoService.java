package com.nomina.nomina.service;

import com.nomina.nomina.model.Movimiento;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovimientoService {
    public List<Movimiento> getMovimientos();

    public List<Movimiento> getMovimientoMes(int movMonth);

    public List<Movimiento> getMovimiento(int empMonth,int empId);

    public ResponseEntity<Object> guardarMov(
                           int movMonth,
                           int movNoEntregas,
                           int movEmpleadoNo
                          );

    public void actualizaMov(
                            int movId,
                            int movHorasT,
                            int movMonth,
                            int movNoEntregas,
                            float movPagoBonos,
                            float movPagoEntregas,
                            float movRetencion,
                            float movSueldo,
                            float movVales,
                            int movEmpleadoId
                            );
}
