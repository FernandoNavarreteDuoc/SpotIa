package com.metodopago.metodospago.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metodopago.metodospago.model.Metodopago;

@Repository
public interface MetodopagoRepository {

    @Query("SELECT m FROM Metodopago m WHERE m.nombre LIKE %:nombre%")
    List<Metodopago> buscarPorNombre(
            @Param("nombre") String nombre
    );
}
