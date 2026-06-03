package com.cliente.clientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cliente.clientes.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query("SELECT c FROM Cliente c WHERE c.nombre LIKE %:nombre%")
    List<Cliente> buscarPorNombre(
            @Param("nombre") String nombre
    );

}
