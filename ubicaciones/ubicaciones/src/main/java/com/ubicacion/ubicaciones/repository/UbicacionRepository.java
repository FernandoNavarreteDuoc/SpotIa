package com.ubicacion.ubicaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ubicacion.ubicaciones.model.Ubicacion;


@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer> {

    @Query("SELECT u FROM Ubicacion u WHERE u.direccion LIKE %:direccion%")
    List<Ubicacion> buscarPorDireccion(
            @Param("direccion") String direccion
    );

}