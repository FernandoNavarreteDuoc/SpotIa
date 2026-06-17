package com.reserva.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reserva.reservas.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    @Query("SELECT e FROM Estado e WHERE e.nombre LIKE %:nombre%")
    List<Estado> buscarPorNombre(
            @Param("nombre") String nombre
    );

}
