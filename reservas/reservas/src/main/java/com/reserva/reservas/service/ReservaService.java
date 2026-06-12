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
    private final ClienteRepository clienteRepo;
    private final LocalRepository localRepo;
    private final ServicioRepository servicioRepo;
    private final MetodopagoRepository metodoPagoRepo;
    private final EstadoRepository estadoRepo;

    private static final Logger logger =
            LoggerFactory.getLogger(ReservaService.class);

    public ReservaService(
            ReservaRepository repository,
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

        Reserva reserva = new Reserva();

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

    public Reserva actualizar(Integer id, ReservaDTO dto) {

        logger.info("Actualizando reserva");

        Reserva reserva = buscarPorId(id);

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