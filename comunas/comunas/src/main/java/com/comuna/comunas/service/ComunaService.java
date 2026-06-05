package com.comuna.comunas.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.comuna.comunas.DTO.ComunaDTO;
import com.comuna.comunas.model.Comuna;
import com.comuna.comunas.repository.ComunaRepository;

@Service
public class ComunaService {
    private final ComunaRepository repository;
    private final RegionRepository regionRepo;

    private static final Logger logger =
            LoggerFactory.getLogger(ComunaService.class);

    public ComunaService(
            ComunaRepository repository,
            RegionRepository regionRepo) {

        this.repository = repository;
        this.regionRepo = regionRepo;
    }

    public List<Comuna> listar() {

        logger.info("Listando comunas");

        return repository.findAll();
    }

    public Comuna buscarPorId(Integer id) {

        logger.info("Buscando comuna");

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Comuna no encontrada"));
    }

    public Comuna guardar(ComunaDTO dto) {

        logger.info("Guardando comuna");

        Region region = regionRepo.findById(dto.getIdRegion())
                .orElseThrow(() ->
                        new RuntimeException("Región no encontrada"));

        Comuna comuna = new Comuna();

        comuna.setNombre(dto.getNombre());
        comuna.setRegion(region);

        return repository.save(comuna);
    }

    public Comuna actualizar(Integer id, ComunaDTO dto) {

        logger.info("Actualizando comuna");

        Comuna comuna = buscarPorId(id);

        Region region = regionRepo.findById(dto.getIdRegion())
                .orElseThrow(() ->
                        new RuntimeException("Región no encontrada"));

        comuna.setNombre(dto.getNombre());
        comuna.setRegion(region);

        return repository.save(comuna);
    }
    
    public void eliminar(Integer id) {

        logger.info("Eliminando comuna");

        repository.deleteById(id);
    }
}
