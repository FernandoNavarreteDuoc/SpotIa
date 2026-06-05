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
    private final ClienteRepository clienteRepo;
    private final LocalRepository localRepo;
    private final ServicioRepository servicioRepo;
    private final MetodopagoRepository metodoPagoRepo;
    private final EstadoRepository estadoRepo;

    private static final Logger logger =
            LoggerFactory.getLogger(ReservasService.class);

    public ReservasService(
            ReservasRepository repository,
            ClienteRepository clienteRepo,
            LocalRepository localRepo,
            ServicioRepository servicioRepo,
            MetodopagoRepository metodoPagoRepo,
            EstadoRepository estadoRepo) {

        this.repository = repository;
        this.clienteRepo = clienteRepo;
        this.localRepo = localRepo;
        this.servicioRepo = servicioRepo;
        this.metodoPagoRepo = metodoPagoRepo;
        this.estadoRepo = estadoRepo;
    }

    public List<Reservas> listar() {

        logger.info("Listando reservas");

        return repository.findAll();
    }

    public Reservas buscarPorId(Integer id) {

        logger.info("Buscando reserva");

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Reserva no encontrada"));
    }

    public Reservas guardar(reservasDTO dto) {

        logger.info("Guardando reserva");

        Cliente cliente = clienteRepo.findById(dto.getRutCliente())
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));

        Local local = localRepo.findById(dto.getIdLocal())
                .orElseThrow(() ->
                        new RuntimeException("Local no encontrado"));

        Servicio servicio = servicioRepo.findById(dto.getIdServicio())
                .orElseThrow(() ->
                        new RuntimeException("Servicio no encontrado"));

        Metodopago metodoPago = metodoPagoRepo.findById(dto.getIdMetodoPago())
                .orElseThrow(() ->
                        new RuntimeException("Método de pago no encontrado"));

        Estado estado = estadoRepo.findById(dto.getIdEstado())
                .orElseThrow(() ->
                        new RuntimeException("Estado no encontrado"));

        Reservas reserva = new Reservas();

        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setHoraReserva(dto.getHoraReserva());
        reserva.setCantidadPersonas(dto.getCantidadPersonas());
        reserva.setTotal(dto.getTotal());

        reserva.setCliente(cliente);
        reserva.setLocal(local);
        reserva.setServicio(servicio);
        reserva.setMetodoPago(metodoPago);
        reserva.setEstado(estado);

        return repository.save(reserva);
    }

    public Reservas actualizar(Integer id, reservasDTO dto) {

        logger.info("Actualizando reserva");

        Reservas reserva = buscarPorId(id);

        Cliente cliente = clienteRepo.findById(dto.getRutCliente())
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));

        Local local = localRepo.findById(dto.getIdLocal())
                .orElseThrow(() ->
                        new RuntimeException("Local no encontrado"));

        Servicio servicio = servicioRepo.findById(dto.getIdServicio())
                .orElseThrow(() ->
                        new RuntimeException("Servicio no encontrado"));

        Metodopago metodoPago = metodoPagoRepo.findById(dto.getIdMetodoPago())
                .orElseThrow(() ->
                        new RuntimeException("Método de pago no encontrado"));

        Estado estado = estadoRepo.findById(dto.getIdEstado())
                .orElseThrow(() ->
                        new RuntimeException("Estado no encontrado"));

        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setHoraReserva(dto.getHoraReserva());
        reserva.setCantidadPersonas(dto.getCantidadPersonas());
        reserva.setTotal(dto.getTotal());

        reserva.setCliente(cliente);
        reserva.setLocal(local);
        reserva.setServicio(servicio);
        reserva.setMetodoPago(metodoPago);
        reserva.setEstado(estado);

        return repository.save(reserva);
    }

    public void eliminar(Integer id) {

        logger.info("Eliminando reserva");

        repository.deleteById(id);
    }
}