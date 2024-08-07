package com.anthonynatareno.system.service;

import java.util.List;
import com.anthonynatareno.system.model.Empleados;

public class IEmpleadosService {
 
    public List<Empleados> listarEmpleados();
 
    public Empleados buscarEmpleados (Integer idEmpleado);
 
    public Empleados guardarEmpleados (Empleados empleados);
 
    public void Empleados eliminarEmpleados(Empleados empleados);
}