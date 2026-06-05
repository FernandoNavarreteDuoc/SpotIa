package com.ubicacion.ubicaciones.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.PaginaSpotIa.DTO.ubicacionDTO;
import com.example.PaginaSpotIa.model.Comuna;
import com.example.PaginaSpotIa.model.Ubicacion;
import com.example.PaginaSpotIa.repository.ComunaRepository;
import com.example.PaginaSpotIa.repository.UbicacionRepository;

@Service
public class UbicacionService {

    private final UbicacionRepository repository;
    private final ComunaRepository comunaRepo;

    private static final Logger logger =
            LoggerFactory.getLogger(UbicacionService.class);

    public UbicacionService(
            UbicacionRepository repository,
            ComunaRepository comunaRepo) {

        this.repository = repository;
        this.comunaRepo = comunaRepo;
    }

    public List<Ubicacion> listar() {

        logger.info("Listando ubicaciones");

        return repository.findAll();
    }

    public Ubicacion buscarPorId(Integer id) {

        logger.info("Buscando ubicación");

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Ubicación no encontrada"));
    }

    public Ubicacion guardar(ubicacionDTO dto) {

        logger.info("Guardando ubicación");

        Comuna comuna = comunaRepo.findById(dto.getIdComuna())
                .orElseThrow(() ->
                        new RuntimeException("Comuna no encontrada"));

        Ubicacion ubicacion = new Ubicacion();

        ubicacion.setDireccion(dto.getDireccion());
        ubicacion.setReferencia(dto.getReferencia());
        ubicacion.setComuna(comuna);

        return repository.save(ubicacion);
    }

    public Ubicacion actualizar(Integer id, ubicacionDTO dto) {

        logger.info("Actualizando ubicación");

        Ubicacion ubicacion = buscarPorId(id);

        Comuna comuna = comunaRepo.findById(dto.getIdComuna())
                .orElseThrow(() ->
                        new RuntimeException("Comuna no encontrada"));

        ubicacion.setDireccion(dto.getDireccion());
        ubicacion.setReferencia(dto.getReferencia());
        ubicacion.setComuna(comuna);

        return repository.save(ubicacion);
    }

    public void eliminar(Integer id) {

        logger.info("Eliminando ubicación");

        repository.deleteById(id);
    }
}
