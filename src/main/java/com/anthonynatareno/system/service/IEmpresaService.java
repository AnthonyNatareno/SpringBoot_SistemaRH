package com.anthonynatareno.system.service;

import java.util.List;
import com.anthonynatareno.system.model.Empresa;

public interface IEmpresaService {
    public List<Empresa> listarEmpleados();
 
    public Empresa buscarEmpresa(Integer idEmpleado);
 
    public Empresa guardarEmpleados(Empresa empleados);
 
    public void eliminarEmpresa(Empresa empleados);
}
