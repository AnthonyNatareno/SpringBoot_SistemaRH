package com.anthonynatareno.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

 
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
 
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;
    String Direccion;
    Integer Telefono;
    String Nombre;
    String Gmail;


 
}
