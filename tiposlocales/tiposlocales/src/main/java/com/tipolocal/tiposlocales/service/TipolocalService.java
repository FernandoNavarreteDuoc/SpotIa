package com.tipolocal.tiposlocales.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tipolocal.tiposlocales.DTO.tipolocalDTO;
import com.tipolocal.tiposlocales.model.Tipolocal;
import com.tipolocal.tiposlocales.repository.TipolocalRepository;

@Service
public class TipolocalService {

    private final TipolocalRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(TipolocalService.class);

    public TipolocalService(TipolocalRepository repository) {

        this.repository = repository;
    }

    public List<Tipolocal> listar() {

        logger.info("Listando tipos de local");

        return repository.findAll();
    }

    public Tipolocal buscarPorId(Integer id) {

        logger.info("Buscando tipo de local");

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Tipo de local no encontrado"));
    }

    public Tipolocal guardar(tipolocalDTO dto) {

        logger.info("Guardando tipo de local");

        Tipolocal tipolocal = new Tipolocal();

        tipolocal.setNombre(dto.getNombre());
        tipolocal.setDescripcion(dto.getDescripcion());

        return repository.save(tipolocal);
    }

    public Tipolocal actualizar(Integer id, tipolocalDTO dto) {

        logger.info("Actualizando tipo de local");

        Tipolocal tipolocal = buscarPorId(id);

        tipolocal.setNombre(dto.getNombre());
        tipolocal.setDescripcion(dto.getDescripcion());

        return repository.save(tipolocal);
    }

    public void eliminar(Integer id) {

        logger.info("Eliminando tipo de local");

        repository.deleteById(id);
    }
}