package com.ubicacion.ubicaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ubicacion.ubicaciones.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    
    @Query("SELECT r FROM Region r WHERE r.nombre LIKE %:nombre%")
    List<Region> buscarPorNombre(
            @Param("nombre") String nombre
    );

}