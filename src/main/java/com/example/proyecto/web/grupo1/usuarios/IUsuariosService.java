package com.example.proyecto.web.grupo1.usuarios;

import java.util.List;
import java.util.Optional;

public interface IUsuariosService {
    public List<Usuarios>Listar();
    public Optional<Usuarios> ConsultarId(int id);
    public void Guardar(Usuarios u);
    public void Eliminar(int id);
    public List<Usuarios> Buscar(String dato);
}
