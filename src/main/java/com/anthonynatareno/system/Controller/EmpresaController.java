package com.anthonynatareno.system.Controller;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthonynatareno.system.service.IEmpresaService;

@RestController //http://localhost:8087:/rh-empresa
@RequestMapping("rh-empresa")

public class EmpresaController {
    private static final System.Logger logger = LoggerFactory.getLogger(EmpresaController.class);

    @Autowired
    private IEmpresaService iEmpresaService;

        //http://localhost:8087/rh-empresa/empresas
        @GetMapping("/empresas")

    
}

