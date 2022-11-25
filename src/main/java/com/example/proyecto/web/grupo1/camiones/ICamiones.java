package com.example.proyecto.web.grupo1.camiones;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICamiones extends CrudRepository<Camiones,Integer>{
    @Query(value="SELECT * FROM camiones "
            + "WHERE placa_tracto LIKE %?1% "
            + "OR placa_carreta LIKE %?1% "
            + "OR marca LIKE %?1% "
            + "OR modelo LIKE %?1%",nativeQuery = true)
    List<Camiones> buscarPorTodo(String dato);
}
