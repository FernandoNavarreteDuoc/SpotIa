package com.cliente.clientes.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cliente.clientes.DTO.ClienteDTO;
import com.cliente.clientes.DTO.ReservaExternaDTO;
import com.cliente.clientes.model.Cliente;
import com.cliente.clientes.repository.ClienteRepository;

import reactor.core.publisher.Mono;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private WebClient.Builder webClientBuilder;
    
    private static final Logger logger =
            LoggerFactory.getLogger(ClienteService.class);

    public List<Cliente> listar() {

        logger.info("Listando clientes");

        return repository.findAll();
    }

    public Cliente buscarPorRut(String rut) {

        logger.info("Buscando cliente");

        return repository.findById(rut)
                .orElseThrow(() ->
                        new RuntimeException("Cliente no encontrado"));
    }

    public Cliente guardar(ClienteDTO dto) {

        logger.info("Guardando cliente");

        Cliente cliente = new Cliente();

        cliente.setRut(dto.getRut());
        cliente.setNombre(dto.getNombre());
        cliente.setDireccion(dto.getDireccion());
        cliente.setTelefono(dto.getTelefono());
        cliente.setCorreo(dto.getCorreo());
        cliente.setContraseña(dto.getContraseña());

        return repository.save(cliente);
    }

    public Cliente actualizar(String rut, ClienteDTO dto) {

        logger.info("Actualizando cliente");

        Cliente cliente = buscarPorRut(rut);

        cliente.setNombre(dto.getNombre());
        cliente.setDireccion(dto.getDireccion());
        cliente.setTelefono(dto.getTelefono());
        cliente.setCorreo(dto.getCorreo());
        cliente.setContraseña(dto.getContraseña());

        return repository.save(cliente);
    }

    public void eliminar(String rut) {

        logger.info("Eliminando cliente");

        repository.deleteById(rut);
    }

    public ClienteDTO convertirADTO(Cliente cliente) {

        ClienteDTO dto = new ClienteDTO();

        dto.setRut(cliente.getRut());
        dto.setNombre(cliente.getNombre());
        dto.setContraseña(cliente.getContraseña());
        dto.setCorreo(cliente.getCorreo());
        dto.setTelefono(cliente.getTelefono());
        dto.setDireccion(cliente.getDireccion());

        try {

            ReservaExternaDTO reservaRecuperada =
                    webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/api/v1/reservas/buscar-por-cliente/" + cliente.getRut())
                    .retrieve()
                    .onStatus(
                            HttpStatusCode::is4xxClientError,
                            response -> Mono.empty()
                    )
                    .bodyToMono(ReservaExternaDTO.class)
                    .block();

            dto.setReserva(reservaRecuperada);

        } catch (Exception e) {

            dto.setReserva(null);
        }

        return dto;
    }
}