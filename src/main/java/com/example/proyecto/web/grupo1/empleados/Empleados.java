package com.example.proyecto.web.grupo1.empleados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincremental
    
    int id;
    String dni;
    String nombre;
    String apellido;
    String sexo;
    String num_licencia;
    String celular;
    String correo;
    String direccion;
}
