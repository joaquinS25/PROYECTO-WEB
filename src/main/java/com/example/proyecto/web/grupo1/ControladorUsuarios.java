package com.example.proyecto.web.grupo1;

import com.example.proyecto.web.grupo1.usuarios.IUsuariosService;
import com.example.proyecto.web.grupo1.usuarios.Usuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorUsuarios {
    @Autowired
    private IUsuariosService serviceUsuarios;
    @GetMapping("/usuarios")
    public String Mostrar(Model model) {
        List<Usuarios> usuarios = serviceUsuarios.Listar();
        model.addAttribute("usuarios", usuarios);
        return "usuarios"; //listapatenciones.html
    }
     @GetMapping("/eliminarUsuario")
    public String Eliminar(@RequestParam("id") int id, Model model) {

        serviceUsuarios.Eliminar(id);
        return Mostrar(model);
    }
    
    @PostMapping("/registroUsuarios")
    public String Registrar(@RequestParam("dni") String dni,
            @RequestParam("nombre") String nom,
            @RequestParam("apellido") String ape,
            @RequestParam("celular") String celular,
            @RequestParam("correo") String correo,
            @RequestParam("direccion") String direc,
            @RequestParam("cargo") String cargo,
            Model model) {
        Usuarios u = new Usuarios();
        u.setDni(dni);
        u.setNombre(nom);
        u.setApellido(ape);
        u.setCelular(celular);
        u.setCorreo(correo);
        u.setDireccion(direc);
        u.setTipoRol(cargo);
        serviceUsuarios.Guardar(u);
        return Mostrar(model);
    }

    /*@GetMapping("/editarEmpleado")
    public String Editar(@RequestParam("id") int id, Model model) {
        Optional<Empleados> empleados = service.ConsultarId(id);
        model.addAttribute("empleados", empleados);
        return "empleados/editarEmpleado"; //editarEmpleado.html
    }*/

    @PostMapping("/actualizarUsuario")
    public String Actualizar(@RequestParam("id") int id,
           @RequestParam("dni") String dni,
            @RequestParam("nombre") String nom,
            @RequestParam("apellido") String ape,
            @RequestParam("celular") String celular,
            @RequestParam("correo") String correo,
            @RequestParam("direccion") String direc,
            @RequestParam("cargo") String cargo,
            Model model) {
        Usuarios u = new Usuarios();
        u.setId(id);
        u.setDni(dni);
        u.setNombre(nom);
        u.setApellido(ape);
        u.setCelular(celular);
        u.setCorreo(correo);
        u.setDireccion(direc);
        u.setTipoRol(cargo);

        serviceUsuarios.Guardar(u);

        return Mostrar(model);
    }

    @PostMapping("/buscarUsuario")
    public String Buscar(@RequestParam("dato") String dato, Model model) {
        List<Usuarios> usuarios = serviceUsuarios.Buscar(dato);

        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

}
