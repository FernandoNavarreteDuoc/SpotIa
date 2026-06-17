package com.local.locales.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.local.locales.DTO.servicioDTO;
import com.local.locales.model.servicio;
import com.local.locales.repository.ServicioRepository;

@Service
public class ServicioService {

    private final ServicioRepository repository;

     private static final Logger logger =
            LoggerFactory.getLogger(LocalService.class);

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
}