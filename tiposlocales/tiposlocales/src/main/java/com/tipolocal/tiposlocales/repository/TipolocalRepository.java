package com.tipolocal.tiposlocales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.PaginaSpotIa.model.Tipolocal;

@Repository
public interface TipolocalRepository
        extends JpaRepository<Tipolocal, Integer> {

    @Query("SELECT t FROM Tipolocal t WHERE t.nombre LIKE %:nombre%")
    List<Tipolocal> buscarPorNombre(
            @Param("nombre") String nombre
    );

}
