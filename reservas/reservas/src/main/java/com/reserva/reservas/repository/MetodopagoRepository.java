package com.reserva.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reserva.reservas.model.Metodopago;

@Repository
public interface MetodopagoRepository extends JpaRepository<Metodopago, Integer>{

    @Query("SELECT m FROM Metodopago m WHERE m.nombre LIKE %:nombre%")
    List<Metodopago> buscarPorNombre(
            @Param("nombre") String nombre
    );
}
