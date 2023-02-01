package com.example.proyecto.web.grupo1.roles;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService implements IRolesService{
    
    @Autowired
    private IRoles data;

    @Override
    public List<Roles> Listar() {
        return (List<Roles>) data.findAll();
    }

    @Override
    public Optional<Roles> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Roles r) {
        data.save(r);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Roles> Buscar(String dato) {
         return data.buscarPorTodo(dato);
    }
    
    
}
