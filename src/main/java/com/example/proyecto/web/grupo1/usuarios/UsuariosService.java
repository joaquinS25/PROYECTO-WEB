package com.example.proyecto.web.grupo1.usuarios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService implements IUsuariosService{

    @Autowired
    private IUsuarios data;
    
    @Override
    public List<Usuarios> Listar() {
        return (List<Usuarios>) data.findAll();
        
    }

    @Override
    public Optional<Usuarios> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Usuarios u) {
       u  = new Usuarios(u.getDni(), u.getNombre(), u.getApellido(), u.getCelular(), u.getCorreo(), u.getDireccion(), u.getPassword(), u.getTipoRol());
        data.save(u);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Usuarios> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }
    
    
    
}
