package com.ubicacion.ubicaciones.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ubicacion.ubicaciones.DTO.ubicacionDTO;
import com.ubicacion.ubicaciones.model.Ubicacion;
import com.ubicacion.ubicaciones.repository.UbicacionRepository;

@Service
public class UbicacionService {

    private final UbicacionRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(UbicacionService.class);

    public UbicacionService(UbicacionRepository repository) {

        this.repository = repository;
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

        Ubicacion ubicacion = new Ubicacion();

        ubicacion.setDireccion(dto.getDireccion());
        ubicacion.setReferencia(dto.getReferencia());
        ubicacion.setIdComuna(dto.getIdComuna());
        return repository.save(ubicacion);
    }

    public Ubicacion actualizar(Integer id, ubicacionDTO dto) {

        logger.info("Actualizando ubicación");

        Ubicacion ubicacion = buscarPorId(id);

        ubicacion.setDireccion(dto.getDireccion());
        ubicacion.setReferencia(dto.getReferencia());
        ubicacion.setIdComuna(dto.getIdComuna());
        return repository.save(ubicacion);
    }

    public void eliminar(Integer id) {

        logger.info("Eliminando ubicación");

        repository.deleteById(id);
    }






    
}