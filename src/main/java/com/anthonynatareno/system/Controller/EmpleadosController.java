package com.anthonynatareno.system.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthonynatareno.system.Excepcion.EmpleadosException;
import com.anthonynatareno.system.model.Empleados;
import com.anthonynatareno.system.service.IEmpleadosService;
 
@RestController //http://localhost:8081:/rh-empleado
@RequestMapping("rh-empleado")
 
public class EmpleadosController {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadosController.class);
 
    @Autowired
    private IEmpleadosService iEmpleadosService;
 
        //http://localhost:8081:/rh-empleado/empleados
        @GetMapping("/empleados")
 
        public List<Empleados> obtenerEmpleado(){
            var empleado2 = iEmpleadosService.listarEmpleados();
            empleado2.forEach((empleado -> logger.info(empleado.toString())));
            return empleado2;
 
        }

        @PostMapping("/empleadosA")
        public Empleados agregarEmpleados (@RequestBody Empleados empleados){
            logger.info("Empleado agregado");
            return iEmpleadosService.guardarEmpleados(empleados);
        }

        @PutMapping("/empleados/{id}")
        public ResponseEntity <Empleados> editarEmpleados (@PathVariable Integer id, @RequestBody Empleados empleadosRecibido){
            Empleados empleados = iEmpleadosService.buscarEmpleados(id);
            if(empleados == null)
                throw new EmpleadosException("El id recibido no existe");
                empleados.setDpi(empleadosRecibido.getDpi());
                empleados.setNombreCompleto(empleadosRecibido.getNombreCompleto());
                empleados.setPuesto(empleadosRecibido.getPuesto());
                empleados.setSalario(empleadosRecibido.getSalario());
                iEmpleadosService.guardarEmpleados(empleados);
                return ResponseEntity.ok(empleados);
        }
}
 