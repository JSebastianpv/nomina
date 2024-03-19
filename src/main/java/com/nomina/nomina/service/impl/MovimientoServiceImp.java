package com.nomina.nomina.service.impl;

import com.nomina.nomina.model.Empleado;
import com.nomina.nomina.model.Movimiento;
import com.nomina.nomina.model.Rol;
import com.nomina.nomina.repository.MovimientoRepository;
import com.nomina.nomina.service.EmpleadoService;
import com.nomina.nomina.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovimientoServiceImp implements MovimientoService {
    @Autowired
    MovimientoRepository movRep;
    @Autowired
    EmpleadoService empServ;

    // Funcion para obtener todos los movimientos
    @Override
    public List<Movimiento> getMovimientos() {
        return (List<Movimiento>) movRep.getMovimientos();
    }

    // Funcion para obtener los movimientos por mes
    @Override
    public List<Movimiento> getMovimientoMes(int movMonth) {
        return (List<Movimiento>) movRep.getMovimientoMes(movMonth);
    }

    // Funcion para obtener un movimiento por id
    @Override
    public List<Movimiento> getMovimientoId(int movId) {
        return (List<Movimiento>) movRep.getMovimientoId(movId);
    }

    // Funcion para obtener un movimiento por mes y empleado
    @Override
    public List<Movimiento> getMovimiento(int empMonth,int empId) {
        return (List<Movimiento>) movRep.getMovimiento(empMonth,empId);
    }

    // Funcion para guardar los movimientos
    @Override
    public ResponseEntity<Object> guardarMov(
                           int movMonth,
                           int movNoEntregas,
                           int movEmpleadoNo,
                           int movFaltas) {
        try {
            // calculo las horas de los dias que no trabajo
            int horasNoTrabajo = 8 * movFaltas;

            // El numero de horas trabajadas al mes considerando que en una semana son 48horas
            int movHorasT = 48 * 4;

            movHorasT = movHorasT - horasNoTrabajo;

            // Busco el empleado de acuerdo a su numero de empleado
            List<Empleado> empleado = empServ.getEmpleado(movEmpleadoNo);
            String nombreRol = "";
            float bonoRol = 0;
            int empleadoId = 0;
            float movPagoBonos = 0;
            for (Empleado emp : empleado) {
                empleadoId = emp.getId();
                Rol rol = emp.getRol();
                nombreRol = rol.getNombre();
                bonoRol = rol.getBono();
            }

            List<Movimiento> movtos = movRep.getMovimiento(movMonth, empleadoId);
            if (!movtos.isEmpty()) {
                Map<String, Object> body = new HashMap<>();
                body.put("error", "Ya existen movimientos de este empleado este mes");
                return ResponseEntity.status(401).body(body);
            }
            /*
            // Si es chofer el bono por hora es de 10
            if (nombreRol.equals("Chofer")) {
                movPagoBonos = movHorasT * 10;
            // Si es Cargador el bono es por 5
            } else if (nombreRol.equals("Cargador")) {
                movPagoBonos = movHorasT * 5;
            }
            */
            movPagoBonos = movHorasT * bonoRol;
            // Calculo el sueldo base de acuerdo a las horas trabajadas por el costo por hora
            float sueldoBase = movHorasT * 30;
            // Calculo el pago por entregas, pagan 5 por cada entrega
            float movPagoEntregas = movNoEntregas * 5;


            float movRetencion = 0,
                    movSueldo = 0,
                    movVales = 0;

            // Sueldo antes de impuestos, aqui se suma el sueldo base mas el pago por las entregas y el bono por hora de acuerdo al rol
            float sueldoAImpuestos = sueldoBase + movPagoEntregas + movPagoBonos;

            // Calculo la retencion de acuerdo al sueldo antes de impuestos y obtengo el valor de la retencion
            movRetencion = (float) (0.09 * sueldoAImpuestos);

            // Valido si el sueldo antes de impuestos fue mayor a 10,000 se aplica un 3% extra que sumare al valor obtenido anterir del 9%
            if (sueldoAImpuestos > 10000) {
                movRetencion = (float) (movRetencion + (0.03 * sueldoAImpuestos));
            }

            // Calculo el sueldo despues de impuestos restando la retencion al sueldo antes de impuestos
            float sueldoDImpuestos = sueldoAImpuestos - movRetencion;

            // Calculo el valor del vale de despensa que es del 4% sobre su sueldo
            movVales = (float) (0.04 * sueldoDImpuestos);

            //El total final es obtenido al sumarle a su sueldo despues de impeustos el vale de despensa
            movSueldo = sueldoDImpuestos + movVales;


            movRep.guardarMov(movHorasT, movMonth, movNoEntregas, movPagoBonos, movPagoEntregas, movRetencion, movSueldo, movVales, empleadoId, bonoRol, nombreRol, sueldoBase, movFaltas );
            return ResponseEntity.ok("Movimiento registrado con Exito");
        } catch (Exception e) {
            throw new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void actualizaMov(int movId,
                             int movHorasT,
                             int movMonth,
                             int movNoEntregas,
                             float movPagoBonos,
                             float movPagoEntregas,
                             float movRetencion,
                             float movSueldo,
                             float movVales,
                             int movEmpleadoId) {
        try {
            // Pendiente
            movRep.actualizaMov(movId,
                    movHorasT,
                    movMonth,
                    movNoEntregas,
                    movPagoBonos,
                    movPagoEntregas,
                    movRetencion,
                    movSueldo,
                    movVales,
                    movEmpleadoId);
        } catch (Exception e) {
            throw new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
