package com.example.proyecto.web.grupo1.roles;

import java.util.List;
import java.util.Optional;

public interface IRolesService {
    public List<Roles>Listar();
    public Optional<Roles> ConsultarId(int id);
    public void Guardar(Roles r);
    public void Eliminar(int id);
    public List<Roles> Buscar(String dato);
}
