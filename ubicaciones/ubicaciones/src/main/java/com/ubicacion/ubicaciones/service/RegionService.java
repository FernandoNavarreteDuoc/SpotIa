package com.ubicacion.ubicaciones.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ubicacion.ubicaciones.DTO.regionDTO;
import com.ubicacion.ubicaciones.model.Region;
import com.ubicacion.ubicaciones.repository.RegionRepository;

@Service
public class RegionService {

    private final RegionRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(RegionService.class);

    public RegionService(RegionRepository repository) {

        this.repository = repository;
    }

    public List<Region> listar() {

        logger.info("Listando regiones");

        return repository.findAll();
    }

    public Region buscarPorId(Integer id) {

        logger.info("Buscando región por id");

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Región no encontrada"));
    }

    public Region guardar(regionDTO dto) {

        logger.info("Guardando región");

        Region region = new Region();

        region.setNombre(dto.getNombre());

        return repository.save(region);
    }

    public Region actualizar(Integer id, regionDTO dto) {

        logger.info("Actualizando región");
        
        Region region = buscarPorId(id);

        region.setNombre(dto.getNombre());

        return repository.save(region);
    }

    public void eliminar(Integer id) {

        logger.info("Eliminando región");

        repository.deleteById(id);
    }
}