package com.example.proyecto.web.grupo1.usuarios;

import com.example.proyecto.web.grupo1.roles.Roles;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    int id;
    String dni;
    String nombre;
    String apellido;
    String celular;
    String correo;
    String direccion;
    String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
    private List<Roles> tipoRol;

    public Usuarios(String dni, String nombre, String apellido, String celular, String correo, String direccion, String password, List<Roles> tipoRol) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.password = password;
        this.tipoRol = tipoRol;
    }

    public Usuarios() {
        
    }
}
