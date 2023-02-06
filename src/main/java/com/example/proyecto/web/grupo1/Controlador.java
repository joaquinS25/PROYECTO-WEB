package com.example.proyecto.web.grupo1;

import com.example.proyecto.web.grupo1.empleados.Empleados;
import com.example.proyecto.web.grupo1.empleados.IEmpleadosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    /*@GetMapping("/registroCamiones")
    public String registroCamiones() {
        return "registroCamiones"; //index.html
    }
    @GetMapping("/registroEmpleados")
    public String registroEmpleados() {
        return "registroEmpleados"; //index.html
    }
    @GetMapping("/registroViajes")
    public String registroViajes() {
        return "registroViajes"; //index.html
    }*/
    @Autowired
    private IEmpleadosService service;

    @GetMapping("/")
    public String login() {
        return "login/login"; //index.html
    }

    @GetMapping("/index")
    public String index() {
        return "index"; //index.html
    }

    @GetMapping("/listadoEmpleados")
    public String Mostrar(Model model) {
        List<Empleados> empleados = service.Listar();
        model.addAttribute("empleados", empleados);
        return "empleados/listadoEmpleados"; //listapatenciones.html
    }

    @GetMapping("/eliminarEmpleado")
    public String Eliminar(@RequestParam("id") int id, Model model) {

        service.Eliminar(id);
        return Mostrar(model);
    }

    @GetMapping("/registroEmpleados") // http://localhost/
    public String registroEmpleados() {
        return "empleados/registroEmpleados"; //new_servicio.html
    }

    @PostMapping("/registroEmpleados")
    public String Registrar(@RequestParam("dni") String dni,
            @RequestParam("nombre") String nom,
            @RequestParam("apellido") String ape,
            @RequestParam("sexo") String sexo,
            @RequestParam("num_licencia") String numLic,
            @RequestParam("celular") String celular,
            @RequestParam("correo") String correo,
            @RequestParam("direccion") String direc,
            Model model) {
        Empleados e = new Empleados();
        e.setDni(dni);
        e.setNombre(nom);
        e.setApellido(ape);
        e.setSexo(sexo);
        e.setNum_licencia(numLic);
        e.setCelular(celular);
        e.setCorreo(correo);
        e.setDireccion(direc);
        service.Guardar(e);
        return Mostrar(model);
    }

    @GetMapping("/editarEmpleado")
    public String Editar(@RequestParam("id") int id, Model model) {
        Optional<Empleados> empleados = service.ConsultarId(id);
        model.addAttribute("empleados", empleados);
        return "empleados/editarEmpleado"; //editarEmpleado.html
    }

    @PostMapping("/actualizar")
    public String Actualizar(@RequestParam("id") int id,
            @RequestParam("dni") String dni,
            @RequestParam("nombre") String nom,
            @RequestParam("apellido") String ape,
            @RequestParam("sexo") String sexo,
            @RequestParam("num_licencia") String numLic,
            @RequestParam("celular") String celular,
            @RequestParam("correo") String correo,
            @RequestParam("direccion") String direc,
            Model model) {
        Empleados e = new Empleados();
        e.setId(id);
        e.setDni(dni);
        e.setNombre(nom);
        e.setApellido(ape);
        e.setSexo(sexo);
        e.setNum_licencia(numLic);
        e.setCelular(celular);
        e.setCorreo(correo);
        e.setDireccion(direc);

        service.Guardar(e);

        return Mostrar(model);
    }

    @PostMapping("/buscar")
    public String Buscar(@RequestParam("dato") String dato, Model model) {
        List<Empleados> empleados = service.Buscar(dato);

        model.addAttribute("empleados", empleados);
        return "empleados/listadoEmpleados";
    }

}
