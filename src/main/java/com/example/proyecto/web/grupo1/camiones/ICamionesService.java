package com.example.proyecto.web.grupo1.camiones;

import java.util.List;
import java.util.Optional;

public interface ICamionesService {
    public List<Camiones> Listar();
    public Optional<Camiones> ConsultarId(int id);
    public void Guardar(Camiones c);
    public void Eliminar(int id);
    public List<Camiones> Buscar(String dato);
}
