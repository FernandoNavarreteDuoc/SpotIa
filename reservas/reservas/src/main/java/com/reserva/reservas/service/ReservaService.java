package com.reserva.reservas.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.reserva.reservas.DTO.ReservaDTO;
import com.reserva.reservas.model.Reserva;
import com.reserva.reservas.repository.ReservaRepository;

@Service
public class ReservaService {

    private final ReservaRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(ReservaService.class);

    public ReservaService(ReservaRepository repository) {

        this.repository = repository;
    }

    public List<Reserva> listar() {

        logger.info("Listando reservas");

        return repository.findAll();
    }

    public Reserva buscarPorId(Integer id) {

        logger.info("Buscando reserva");

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Reserva no encontrada"));
    }

    public Reserva guardar(ReservaDTO dto) {

        logger.info("Guardando reserva");

        Reserva reserva = new Reserva();

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

    public Reserva actualizar(Integer id, ReservaDTO dto) {

        logger.info("Actualizando reserva");

        Reserva reserva = buscarPorId(id);

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