package com.reserva.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reserva.reservas.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query("SELECT r FROM Reserva r WHERE r.total >= :total")
    List<Reserva> buscarReservasCostosas(
            @Param("total") Integer total
    );
    Reserva findByRutCliente (String rutCliente);

}