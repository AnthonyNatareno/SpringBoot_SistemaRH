package com.anthonynatareno.system.repository;

    

import org.springframework.data.jpa.repository.JpaRepository;
import com.anthonynatareno.system.model.Empresa;


public interface EmpresaRepositorio extends JpaRepository<Empresa , Integer> {
 
 
}