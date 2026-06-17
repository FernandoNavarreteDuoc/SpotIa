package com.local.locales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.local.locales.model.servicio;

@Repository
public interface ServicioRepository extends JpaRepository<servicio, Integer> {

    @Query("SELECT s FROM servicio s WHERE s.nombre LIKE %:nombre%")
    List<servicio> buscarPorNombre(
            @Param("nombre") String nombre
    );

}