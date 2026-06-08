package com.local.locales.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.local.locales.DTO.localDTO;
import com.local.locales.model.Local;
import com.local.locales.repository.LocalRepository;

@Service
public class LocalService {

    private final LocalRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(LocalService.class);

    public LocalService(LocalRepository repository) {
        this.repository = repository;
    }

    public List<Local> listar() {
        logger.info("Listando locales");
        return repository.findAll();
    }

    public Local buscarPorId(Integer id) {
        logger.info("Buscando local");
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local no encontrado"));
    }

    public Local guardar(localDTO dto) {
        logger.info("Guardando local");
        Local local = new Local();
        local.setNombre(dto.getNombre());
        local.setDescripcion(dto.getDescripcion());
        local.setCapacidad(dto.getCapacidad());
        local.setIdTipoLocal(dto.getIdTipoLocal());
        local.setIdUbicacion(dto.getIdUbicacion());
        return repository.save(local);
    }

    public Local actualizar(Integer id, localDTO dto) {
        logger.info("Actualizando local");
        Local local = buscarPorId(id);
        local.setNombre(dto.getNombre());
        local.setDescripcion(dto.getDescripcion());
        local.setCapacidad(dto.getCapacidad());
        local.setIdTipoLocal(dto.getIdTipoLocal());
        local.setIdUbicacion(dto.getIdUbicacion());
        return repository.save(local);
    }

    public void eliminar(Integer id) {
        logger.info("Eliminando local");
        repository.deleteById(id);
    }
}
