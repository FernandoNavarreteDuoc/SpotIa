package com.servicio.servicios.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.PaginaSpotIa.DTO.servicioDTO;
import com.example.PaginaSpotIa.model.Servicio;
import com.example.PaginaSpotIa.repository.ServicioRepository;

@Service
public class ServicioService {

    private final ServicioRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(ServicioService.class);

    public ServicioService(ServicioRepository repository) {

        this.repository = repository;
    }

    public List<Servicio> listar() {

        logger.info("Listando servicios");

        return repository.findAll();
    }

    public Servicio buscarPorId(Integer id) {

        logger.info("Buscando servicio");

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Servicio no encontrado"));
    }

    public Servicio guardar(servicioDTO dto) {

        logger.info("Guardando servicio");

        Servicio servicio = new Servicio();

        servicio.setNombre(dto.getNombre());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setPrecio(dto.getPrecio());

        return repository.save(servicio);
    }

    public Servicio actualizar(Integer id, servicioDTO dto) {

        logger.info("Actualizando servicio");

        Servicio servicio = buscarPorId(id);

        servicio.setNombre(dto.getNombre());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setPrecio(dto.getPrecio());

        return repository.save(servicio);
    }

    public void eliminar(Integer id) {

        logger.info("Eliminando servicio");

        repository.deleteById(id);
    }
}