package com.estado.estados.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.estado.estados.DTO.EstadoDTO;
import com.estado.estados.model.Estado;
import com.estado.estados.repository.EstadoRepository;

@Service
public class EstadoService {

    private final EstadoRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(EstadoService.class);

    public EstadoService(EstadoRepository repository) {

        this.repository = repository;
    }

    public List<Estado> listar() {

        logger.info("Listando estados");

        return repository.findAll();
    }

    public Estado buscarPorId(Integer id) {

        logger.info("Buscando estado");

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Estado no encontrado"));
    }

    public Estado guardar(EstadoDTO dto) {

        logger.info("Guardando estado");

        Estado estado = new Estado();

        estado.setNombre(dto.getNombre());
        estado.setDescripcion(dto.getDescripcion());

        return repository.save(estado);
    }

    public Estado actualizar(Integer id, EstadoDTO dto) {

        logger.info("Actualizando estado");

        Estado estado = buscarPorId(id);

        estado.setNombre(dto.getNombre());
        estado.setDescripcion(dto.getDescripcion());

        return repository.save(estado);
    }

    public void eliminar(Integer id) {

        logger.info("Eliminando estado");

        repository.deleteById(id);
    }
}
