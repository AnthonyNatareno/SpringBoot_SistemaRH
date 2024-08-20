package com.anthonynatareno.system.service;

import java.util.List;
import com.anthonynatareno.system.model.Empresa;

public interface IEmpresaService {
    public List<Empresa> listarEmpresa();
 
    public Empresa buscarEmpresa(Integer idempresa);
 
    public Empresa guardarEmpresa(Empresa empresa);
 
    public void eliminarEmpresa(Empresa empresa);
}
