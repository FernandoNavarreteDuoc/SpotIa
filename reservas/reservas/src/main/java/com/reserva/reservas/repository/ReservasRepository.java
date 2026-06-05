package com.reserva.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reserva.reservas.model.Reservas;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Integer> {

    @Query("SELECT r FROM Reservas r WHERE r.total >= :total")
    List<Reservas> buscarReservasCostosas(
            @Param("total") Integer total
    );

}