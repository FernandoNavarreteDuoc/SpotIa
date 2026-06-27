package com.local.locales.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.local.locales.DTO.ReservaExternaDTO;
import com.local.locales.DTO.servicioDTO;
import com.local.locales.model.servicio;
import com.local.locales.repository.ServicioRepository;

import reactor.core.publisher.Mono;

@Service
public class ServicioService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final ServicioRepository repository;

    private static final Logger logger =
        LoggerFactory.getLogger(ServicioService.class);

    public ServicioService(ServicioRepository repository) {
        this.repository = repository;
    }

    public List<servicio> listar() {

        logger.info("Listando servicios");
        return repository.findAll();
    }

    public servicio buscarPorId(Integer id) {
        logger.info("Buscando servicio");
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Servicio no encontrado"));
    }

    public servicio guardar(servicioDTO dto) {

        logger.info("Guardando servicio");
        servicio servicio = new servicio();

        servicio.setNombre(dto.getNombre());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setPrecio(dto.getPrecio());

        return repository.save(servicio);
    }

    public servicio actualizar(Integer id, servicioDTO dto) {
        logger.info("Actualizando servicio");

        servicio servicio = buscarPorId(id);

        servicio.setNombre(dto.getNombre());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setPrecio(dto.getPrecio());

        return repository.save(servicio);
    }

    public void eliminar(Integer id) {

        repository.deleteById(id);
    }

        public servicioDTO convertirADTO(servicio servicio) {

        servicioDTO dto = new servicioDTO();

        dto.setDescripcion(servicio.getDescripcion());
        dto.setIdServicio(servicio.getIdServicio());
        dto.setNombre(servicio.getNombre());
        dto.setPrecio(servicio.getPrecio());

        try {

            ReservaExternaDTO reservaRecuperada = webClientBuilder.build()
                    .get()
                    .uri("http://reservas/api/v1/reservas/buscarporservicio/" + servicio.getIdServicio())
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.empty())
                    .bodyToMono(ReservaExternaDTO.class)
                    .block();

            dto.setReserva(reservaRecuperada);

        } catch (Exception e) {

            dto.setReserva(null);
        }

        return dto;
    }
}