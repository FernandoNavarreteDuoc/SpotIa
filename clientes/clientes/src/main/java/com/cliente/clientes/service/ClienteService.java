package com.cliente.clientes.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cliente.clientes.DTO.ClienteDTO;
import com.cliente.clientes.model.Cliente;
import com.cliente.clientes.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(ClienteService.class);

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listar() {
        logger.info("Listando clientes");
        return repository.findAll();
    }

    public Cliente buscarPorRut(String rut) {
        logger.info("Buscando cliente");
        return repository.findById(rut)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
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
}
