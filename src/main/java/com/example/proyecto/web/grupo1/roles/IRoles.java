package com.example.proyecto.web.grupo1.roles;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoles extends CrudRepository<Roles, Integer>{
    
    @Query(value="SELECT * FROM roles "
            + "WHERE cargo LIKE %?1%",nativeQuery = true)
    List<Roles> buscarPorTodo(String dato);
}
