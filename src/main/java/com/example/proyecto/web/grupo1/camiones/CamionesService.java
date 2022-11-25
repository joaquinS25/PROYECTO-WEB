package com.example.proyecto.web.grupo1.camiones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamionesService implements ICamionesService{

    @Autowired
    private ICamiones data;

    @Override
    public List<Camiones> Listar() {
        return (List<Camiones>) data.findAll();
    }

    @Override
    public Optional<Camiones> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Camiones a) {
        data.save(a);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Camiones> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }

}
