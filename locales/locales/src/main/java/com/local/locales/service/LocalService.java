package com.local.locales.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.local.locales.DTO.ReservaExternaDTO;
import com.local.locales.DTO.localDTO;
import com.local.locales.model.Local;
import com.local.locales.repository.LocalRepository;

import reactor.core.publisher.Mono;

@Service
public class LocalService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final LocalRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(LocalService.class);

    public LocalService(LocalRepository repository) {
        this.repository = repository;
    }

    public List<Local> listar() {
        logger.info("Listando locales");
        return repository.findAll();
    }

    public Local buscarPorId(Integer id) {
        logger.info("Buscando local");
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local no encontrado"));
    }

    public Local guardar(localDTO dto) {
        logger.info("Guardando local");
        Local local = new Local();
        local.setNombre(dto.getNombre());
        local.setDescripcion(dto.getDescripcion());
        local.setCapacidad(dto.getCapacidad());
        local.setIdTipoLocal(dto.getIdTipoLocal());
        local.setIdUbicacion(dto.getIdUbicacion());
        return repository.save(local);
    }

    public Local actualizar(Integer id, localDTO dto) {
        logger.info("Actualizando local");
        Local local = buscarPorId(id);
        local.setNombre(dto.getNombre());
        local.setDescripcion(dto.getDescripcion());
        local.setCapacidad(dto.getCapacidad());
        local.setIdTipoLocal(dto.getIdTipoLocal());
        local.setIdUbicacion(dto.getIdUbicacion());
        return repository.save(local);
    }

    public void eliminar(Integer id) {
        logger.info("Eliminando local");
        repository.deleteById(id);
    }

       public localDTO convertirADTO(Local local) {

        localDTO dto = new localDTO();

        dto.setCapacidad(local.getCapacidad());
        dto.setDescripcion(local.getDescripcion());
        dto.setIdLocal(local.getIdLocal());
        dto.setIdTipoLocal(local.getIdTipoLocal());
        dto.setIdUbicacion(local.getIdUbicacion());
        dto.setNombre(local.getNombre());

        try {

            ReservaExternaDTO reservaRecuperada = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/api/v1/reservas/buscarporlocal/" + local.getIdLocal())
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
