package com.example.proyecto.web.grupo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ControladorLogin {
    @GetMapping("/login") // http://localhost/
    public String registroCamiones() {
        return "login/login"; //login.html
    }
}
