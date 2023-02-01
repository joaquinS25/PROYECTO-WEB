package com.example.proyecto.web.grupo1.usuarios;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarios extends CrudRepository<Usuarios, Integer>{
    
    @Query(value="SELECT * FROM usuarios "
            + "WHERE dni LIKE %?1% "
            + "OR nombre LIKE %?1%",nativeQuery = true)
    List<Usuarios> buscarPorTodo(String dato);
}
