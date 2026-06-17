package com.local.locales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD:servicios/servicios/src/main/java/com/servicio/servicios/repository/ServicioRepository.java
import com.servicio.servicios.model.servicio;

@Repository
public interface ServicioRepository
        extends JpaRepository<servicio, Integer> {
=======
import com.local.locales.model.servicio;

@Repository
public interface ServicioRepository extends JpaRepository<servicio, Integer> {
>>>>>>> 20eaf0a2de7df1ebffeaecb80283babc2368ca3a:locales/locales/src/main/java/com/local/locales/repository/ServicioRepository.java

    @Query("SELECT s FROM servicio s WHERE s.nombre LIKE %:nombre%")
    List<servicio> buscarPorNombre(
            @Param("nombre") String nombre
    );
}