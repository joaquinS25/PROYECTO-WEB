package com.example.proyecto.web.grupo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorRestablecer {
     @GetMapping("/restablecer") // http://localhost/
    public String registroCamiones() {
        return "login/restablecer"; //restablecer.html
    }
}
