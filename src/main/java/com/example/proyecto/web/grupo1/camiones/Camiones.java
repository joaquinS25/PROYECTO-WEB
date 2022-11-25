package com.example.proyecto.web.grupo1.camiones;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="camiones")
public class Camiones {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincremental
    private int id;
    private String PlacaTracto;
    private String PlacaCarreta;
    private String Marca;
    private String Modelo;
}
