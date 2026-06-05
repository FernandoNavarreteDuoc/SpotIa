package com.local.locales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.PaginaSpotIa.model.Local;

@Repository
public interface LocalRepository
        extends JpaRepository<Local, Integer> {

    @Query("SELECT l FROM Local l WHERE l.capacidad >= :capacidad")
    List<Local> buscarLocalesGrandes(
            @Param("capacidad") Integer capacidad
    );

}