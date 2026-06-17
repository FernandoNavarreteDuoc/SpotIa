package com.ubicacion.ubicaciones.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ubicacion.ubicaciones.DTO.ComunaDTO;
import com.ubicacion.ubicaciones.model.Comuna;
import com.ubicacion.ubicaciones.repository.ComunaRepository;

@Service
public class ComunaService {

    private final ComunaRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(ComunaService.class);

    public ComunaService(ComunaRepository repository) {
        this.repository = repository;
    }

    public List<Comuna> listar() {
        logger.info("Listando comunas");
        return repository.findAll();
    }

    public Comuna buscarPorId(Integer id) {
        logger.info("Buscando comuna");
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comuna no encontrada"));
    }

    public Comuna guardar(ComunaDTO dto) {
        logger.info("Guardando comuna");
        Comuna comuna = new Comuna();
        comuna.setNombre(dto.getNombre());
        comuna.setIdRegion(dto.getIdRegion());
        return repository.save(comuna);
    }

    public Comuna actualizar(Integer id, ComunaDTO dto) {
        logger.info("Actualizando comuna");
        Comuna comuna = buscarPorId(id);
        comuna.setNombre(dto.getNombre());
        comuna.setIdRegion(dto.getIdRegion());
        return repository.save(comuna);
    }

    public void eliminar(Integer id) {
        logger.info("Eliminando comuna");
        repository.deleteById(id);
    }
}
