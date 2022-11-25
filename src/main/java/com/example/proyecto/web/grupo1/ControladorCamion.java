package com.example.proyecto.web.grupo1;

import com.example.proyecto.web.grupo1.camiones.Camiones;
import com.example.proyecto.web.grupo1.camiones.ICamionesService;
import com.example.proyecto.web.grupo1.empleados.Empleados;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorCamion {
    @Autowired
    private ICamionesService service;

    @GetMapping("/listadoCamiones")
    public String Mostrar(Model model) {
        List<Camiones> camiones = service.Listar();
        model.addAttribute("Camiones", camiones);
        return "camiones/listadoCamiones"; //listadiCamiones.html
    }

    @GetMapping("/eliminarCamion")
    public String Eliminar(@RequestParam("id") int id, Model model) {

        service.Eliminar(id);
        return Mostrar(model);
    }

    @GetMapping("/registroCamiones") // http://localhost/
    public String registroCamiones() {
        return "camiones/registroCamiones"; //new_servicio.html
    }

    @PostMapping("/registroCamiones")
    public String Registrar(@RequestParam("PlacaTracto") String PlacaTracto,
            @RequestParam("PlacaCarreta") String PlacaCarreta,
            @RequestParam("Marca") String Marca,
            @RequestParam("Modelo") String Modelo,
            Model model) {
        Camiones c = new Camiones();
        c.setPlacaTracto(PlacaTracto);
        c.setPlacaCarreta(PlacaCarreta);
        c.setMarca(Marca);
        c.setModelo(Modelo);
        
        service.Guardar(c);
        return Mostrar(model);
    }
     @GetMapping("/editarCamion")
    public String Editar(@RequestParam("id") int id, Model model) {
        Optional<Camiones> camiones = service.ConsultarId(id);
        model.addAttribute("Camiones", camiones);
        return "camiones/editarCamion"; //editarEmpleado.html
    }

    @PostMapping("/actualizarCamiones")
    public String Actualizar(@RequestParam("id") int id,
            @RequestParam("PlacaTracto") String PlacaTracto,
            @RequestParam("PlacaCarreta") String PlacaCarreta,
            @RequestParam("Marca") String Marca,
            @RequestParam("Modelo") String Modelo,
            Model model) {
        Camiones c = new Camiones();
        c.setId(id);
        c.setPlacaTracto(PlacaTracto);
        c.setPlacaCarreta(PlacaCarreta);
        c.setMarca(Marca);
        c.setModelo(Modelo);
        

        service.Guardar(c);

        return Mostrar(model);
    }

    @PostMapping("/buscarCamion")
    public String Buscar(@RequestParam("dato") String dato, Model model) {
        List<Camiones> camiones = service.Buscar(dato);

        model.addAttribute("Camiones", camiones);
        return "camiones/listadoCamiones";
    }
}
