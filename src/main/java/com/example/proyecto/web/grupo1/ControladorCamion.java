package com.example.proyecto.web.grupo1;

import com.example.proyecto.web.grupo1.camiones.Camiones;
import com.example.proyecto.web.grupo1.camiones.ICamionesService;
import com.example.proyecto.web.grupo1.carretas.Carretas;
import com.example.proyecto.web.grupo1.carretas.ICarretasService;
import com.example.proyecto.web.grupo1.empleados.Empleados;
import com.example.proyecto.web.grupo1.tractos.ITractos;
import com.example.proyecto.web.grupo1.tractos.ITractosService;
import com.example.proyecto.web.grupo1.tractos.Tractos;
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

    @Autowired
    private ICarretasService serviceC;

    @Autowired
    private ITractosService serviceT;

    @GetMapping("/listadoCamiones")
    public String Mostrar(Model model) {
        List<Camiones> Camiones = service.Listar();
        model.addAttribute("camiones", Camiones);

        List<Tractos> tractos = serviceT.Listar();
        model.addAttribute("tractos", tractos);

        List<Carretas> carretas = serviceC.Listar();
        model.addAttribute("carretas", carretas);

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
    public String Registrar(@RequestParam("PlacaCarreta") Carretas PlacaCarreta,
            @RequestParam("Estado") String Estado,
            @RequestParam("PlacaTracto") Tractos PlacaTracto,
            @RequestParam("Marca") String Marca,
            @RequestParam("Modelo") String Modelo,
            Model model) {
        Camiones c = new Camiones();
        c.setCarretas(PlacaCarreta);
        c.setEstado(Estado);
        c.setTractos(PlacaTracto);
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
            @RequestParam("PlacaCarreta") Carretas PlacaCarreta,
            @RequestParam("Estado") String Estado,
            @RequestParam("PlacaTracto") Tractos PlacaTracto,
            @RequestParam("Marca") String Marca,
            @RequestParam("Modelo") String Modelo,
            Model model) {
        Camiones c = new Camiones();
        c.setId(id);
        c.setCarretas(PlacaCarreta);
        c.setEstado(Estado);
        c.setTractos(PlacaTracto);
        c.setMarca(Marca);
        c.setModelo(Modelo);

        service.Guardar(c);

        return Mostrar(model);
    }

    @PostMapping("/buscarCamion")
    public String Buscar(@RequestParam("dato") String dato, Model model) {
        List<Camiones> Camiones = service.Buscar(dato);
        model.addAttribute("camiones", Camiones);

        List<Tractos> tractos = serviceT.Listar();
        model.addAttribute("tractos", tractos);

        List<Carretas> carretas = serviceC.Listar();
        model.addAttribute("carretas", carretas);

        return "camiones/listadoCamiones";
    }
}
