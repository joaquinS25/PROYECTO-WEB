package com.example.proyecto.web.grupo1.camiones;

import com.example.proyecto.web.grupo1.carretas.Carretas;
import com.example.proyecto.web.grupo1.tractos.Tractos;
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
@Table(name="camiones")
public class Camiones {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincremental
    private int id;
    @ManyToOne()
    @JoinColumn(name="tractos_id")
    private Tractos Tractos;
    @ManyToOne()
    @JoinColumn(name="carretas_id")
    private Carretas Carretas;
    private String Marca;
    private String Modelo;
    private String Estado;
}
