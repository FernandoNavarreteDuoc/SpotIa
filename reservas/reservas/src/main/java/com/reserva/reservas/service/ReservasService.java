package com.reserva.reservas.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.reserva.reservas.DTO.reservasDTO;
import com.reserva.reservas.model.reservas;
import com.reserva.reservas.repository.ReservasRepository;

@Service
public class ReservasService {

    private final ReservasRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(ReservasService.class);

    public ReservasService(ReservasRepository repository) {

        this.repository = repository;
    }

    public List<reservas> listar() {

        logger.info("Listando reservas");

        return repository.findAll();
    }

    public reservas buscarPorId(Integer id) {

        logger.info("Buscando reserva");

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Reserva no encontrada"));
    }

    public reservas guardar(reservasDTO dto) {

        logger.info("Guardando reserva");

        reservas reserva = new reservas();

        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setHoraReserva(dto.getHoraReserva());
        reserva.setCantidadPersonas(dto.getCantidadPersonas());
        reserva.setTotal(dto.getTotal());

        reserva.setRutCliente(dto.getRutCliente());
        reserva.setIdLocal(dto.getIdLocal());
        reserva.setIdServicio(dto.getIdServicio());
        reserva.setIdMetodoPago(dto.getIdMetodoPago());
        reserva.setIdEstado(dto.getIdEstado());

        return repository.save(reserva);
    }

    public reservas actualizar(Integer id, reservasDTO dto) {

        logger.info("Actualizando reserva");

        reservas reserva = buscarPorId(id);

        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setHoraReserva(dto.getHoraReserva());
        reserva.setCantidadPersonas(dto.getCantidadPersonas());
        reserva.setTotal(dto.getTotal());

        reserva.setRutCliente(dto.getRutCliente());
        reserva.setIdLocal(dto.getIdLocal());
        reserva.setIdServicio(dto.getIdServicio());
        reserva.setIdMetodoPago(dto.getIdMetodoPago());
        reserva.setIdEstado(dto.getIdEstado());

        return repository.save(reserva);
    }

    public void eliminar(Integer id) {

        logger.info("Eliminando reserva");

        repository.deleteById(id);
    }
}