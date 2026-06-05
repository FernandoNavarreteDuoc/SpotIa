package com.local.locales.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.PaginaSpotIa.DTO.localDTO;
import com.example.PaginaSpotIa.model.Local;
import com.example.PaginaSpotIa.model.Tipolocal;
import com.example.PaginaSpotIa.model.Ubicacion;
import com.example.PaginaSpotIa.repository.LocalRepository;
import com.example.PaginaSpotIa.repository.TipolocalRepository;
import com.example.PaginaSpotIa.repository.UbicacionRepository;

@Service
public class LocalService {

    private final LocalRepository repository;
    private final TipolocalRepository tipoLocalRepo;
    private final UbicacionRepository ubicacionRepo;

    private static final Logger logger =
            LoggerFactory.getLogger(LocalService.class);

    public LocalService(
            LocalRepository repository,
            TipolocalRepository tipoLocalRepo,
            UbicacionRepository ubicacionRepo) {

        this.repository = repository;
        this.tipoLocalRepo = tipoLocalRepo;
        this.ubicacionRepo = ubicacionRepo;
    }

    public List<Local> listar() {

        logger.info("Listando locales");

        return repository.findAll();
    }

    public Local buscarPorId(Integer id) {

        logger.info("Buscando local");

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Local no encontrado"));
    }

    public Local guardar(localDTO dto) {

        logger.info("Guardando local");

        Tipolocal tipoLocal = tipoLocalRepo.findById(dto.getIdTipoLocal())
                .orElseThrow(() ->
                        new RuntimeException("Tipo de local no encontrado"));

        Ubicacion ubicacion = ubicacionRepo.findById(dto.getIdUbicacion())
                .orElseThrow(() ->
                        new RuntimeException("Ubicación no encontrada"));

        Local local = new Local();

        local.setNombre(dto.getNombre());
        local.setDescripcion(dto.getDescripcion());
        local.setCapacidad(dto.getCapacidad());
        local.setTipoLocal(tipoLocal);
        local.setUbicacion(ubicacion);

        return repository.save(local);
    }

    public Local actualizar(Integer id, localDTO dto) {

        logger.info("Actualizando local");

        Local local = buscarPorId(id);

        Tipolocal tipoLocal = tipoLocalRepo.findById(dto.getIdTipoLocal())
                .orElseThrow(() ->
                        new RuntimeException("Tipo de local no encontrado"));

        Ubicacion ubicacion = ubicacionRepo.findById(dto.getIdUbicacion())
                .orElseThrow(() ->
                        new RuntimeException("Ubicación no encontrada"));

        local.setNombre(dto.getNombre());
        local.setDescripcion(dto.getDescripcion());
        local.setCapacidad(dto.getCapacidad());
        local.setTipoLocal(tipoLocal);
        local.setUbicacion(ubicacion);

        return repository.save(local);
    }

    public void eliminar(Integer id) {

        logger.info("Eliminando local");

        repository.deleteById(id);
    }
}