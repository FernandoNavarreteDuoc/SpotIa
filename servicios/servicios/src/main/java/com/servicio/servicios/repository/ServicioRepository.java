package com.servicio.servicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.PaginaSpotIa.model.Servicio;

@Repository
public interface ServicioRepository
        extends JpaRepository<Servicio, Integer> {

    @Query("SELECT s FROM Servicio s WHERE s.nombre LIKE %:nombre%")
    List<Servicio> buscarPorNombre(
            @Param("nombre") String nombre
    );

}