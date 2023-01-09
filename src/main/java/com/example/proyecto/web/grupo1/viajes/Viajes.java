package com.example.proyecto.web.grupo1.viajes;

import com.example.proyecto.web.grupo1.camiones.Camiones;
import com.example.proyecto.web.grupo1.carretas.Carretas;
import com.example.proyecto.web.grupo1.empleados.Empleados;
import com.example.proyecto.web.grupo1.tractos.Tractos;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="viajes")
public class Viajes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincremental
    private int id;
    private Date Fecha;
    private String TipoServicio;
    private String Cliente;
    private String Destino;
    private String AlmacenRetiroContenedor;
    private String AlmacenDevolucionContenedor;
    private float MontoViaje;
    
   
    @ManyToOne()
    @JoinColumn(name="empleado_Id")
    private Empleados Empleados;
    
     @ManyToOne()
    @JoinColumn(name="tractos_id")
    private Tractos Tractos;
    
    @ManyToOne()
    @JoinColumn(name="carretas_id")
    private Carretas Carretas;
    
    
}
