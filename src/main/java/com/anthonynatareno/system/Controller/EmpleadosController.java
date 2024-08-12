package com.anthonynatareno.system.Controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.anthonynatareno.system.service.IEmpleadosService;
import com.anthonynatareno.system.model.Empleados;
 
@RestController //http://localhost:8081:/rh-empleado
@RequestMapping("rh-empleado")
 
public class EmpleadosController {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadosController.class);
 
    @Autowired
    private IEmpleadosService iEmpleadosService;
 
        //http://localhost:8081:/rh-empleado/empleados
        @GetMapping("/empleados")
 
        public List<Empleados> obtenerEmpleado(){
            var empleado2 = iEmpleadosService.listarEmpleados
            empleado2.forEach((empleado -> logger.info(empleado.toString())));
            return empleado2;
 
        }
}
 