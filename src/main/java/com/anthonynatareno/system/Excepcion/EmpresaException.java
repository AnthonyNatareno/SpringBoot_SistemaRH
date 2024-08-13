package com.anthonynatareno.system.Excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmpresaException extends RuntimeException{
   
    public EmpresaException(String mensaje){
        super(mensaje);
    }
 

}
