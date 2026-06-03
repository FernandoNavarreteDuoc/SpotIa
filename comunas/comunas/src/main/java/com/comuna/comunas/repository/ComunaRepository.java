package com.comuna.comunas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comuna.comunas.model.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer> {

    @Query("SELECT c FROM Comuna c WHERE c.nombre LIKE %:nombre%")
    List<Comuna> buscarPorNombre(
            @Param("nombre") String nombre
    );

}
