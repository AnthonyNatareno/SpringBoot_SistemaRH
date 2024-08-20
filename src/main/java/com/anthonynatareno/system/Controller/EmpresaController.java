package com.anthonynatareno.system.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthonynatareno.system.Excepcion.EmpresaException;
import com.anthonynatareno.system.model.Empresa;
import com.anthonynatareno.system.service.IEmpresaService;


 
@RestController //http://localhost:8081:/rh-empresa
@RequestMapping("rh-empresa")
 
public class EmpresaController {
    private static final Logger logger = LoggerFactory.getLogger(EmpresaController.class);
 
    @Autowired
    private IEmpresaService iEmpresaService;
 
        //http://localhost:8087/rh-empresa/empresaA
        @GetMapping("/empresa")
 
        public List<Empresa> obtenerEmpresa(){
            var empresas = iEmpresaService.listarEmpresa();
            empresas.forEach((empresa -> logger.info(empresa.toString())));
            return empresas;
 
        }

        @PostMapping("/empresaA")
        public Empresa agregarEmpresa (@RequestBody Empresa empresa){
            logger.info("Empresa agregada");
            return iEmpresaService.guardarEmpresa(empresa);
        }

        @PutMapping("/empresa/{id}")
        public ResponseEntity <Empresa> editarEmpresa (@PathVariable Integer id, @RequestBody Empresa empresaRecibido){
            Empresa empresa = iEmpresaService.buscarEmpresa(id);
            if(empresa == null)
                throw new EmpresaException("El id recibido no existe");
                empresa.setId(empresaRecibido.getId());
                empresa.setDireccion(empresaRecibido.getDireccion());
                empresa.setTelefono(empresaRecibido.getTelefono());
                empresa.setNombre(empresaRecibido.getNombre());
                iEmpresaService.guardarEmpresa(empresa);
                return ResponseEntity.ok(empresa);
        }

         @DeleteMapping("/empresa/{id}")
        public ResponseEntity<Map<String, Boolean>> eliminarEmpresa(@PathVariable Integer id){
            Empresa empresa = iEmpresaService.buscarEmpresa(id);
            if(empresa == null)
                throw new EmpresaException("La empresa no existe");

                // JSON {eliminado: true}

                Map<String, Boolean> respuesta = new HashMap<>();
                respuesta.put("eliminado", true);
                return ResponseEntity.ok(respuesta);
        } 
}

