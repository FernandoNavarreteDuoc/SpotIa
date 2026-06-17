package com.servicio.servicios.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.servicio.servicios.DTO.servicioDTO;
import com.servicio.servicios.model.servicio;
import com.servicio.servicios.repository.ServicioRepository;

@Service
public class ServicioService {

    private final ServicioRepository repository;

    public ServicioService(ServicioRepository repository) {

        this.repository = repository;
    }

    public List<servicio> listar() {

        return repository.findAll();
    }

    public servicio buscarPorId(Integer id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Servicio no encontrado"));
    }

    public servicio guardar(servicioDTO dto) {

        servicio servicio = new servicio();

        servicio.setNombre(dto.getNombre());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setPrecio(dto.getPrecio());

        return repository.save(servicio);
    }

    public servicio actualizar(Integer id, servicioDTO dto) {

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