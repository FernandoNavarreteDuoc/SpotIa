package com.metodopago.metodospago.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.metodopago.metodospago.DTO.MetodopagoDTO;
import com.metodopago.metodospago.model.Metodopago;
import com.metodopago.metodospago.repository.MetodopagoRepository;

@Service
public class MetodopagoService {

    private final MetodopagoRepository repository;

    private static final Logger logger =
            LoggerFactory.getLogger(MetodopagoService.class);

    public MetodopagoService(MetodopagoRepository repository) {

        this.repository = repository;
    }

    public List<Metodopago> listar() {

        logger.info("Listando métodos de pago");

        return repository.findAll();
    }

    public Metodopago buscarPorId(Integer id) {

        logger.info("Buscando método de pago");

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Método de pago no encontrado"));
    }

    public Metodopago guardar(MetodopagoDTO dto) {

        logger.info("Guardando método de pago");

        Metodopago metodoPago = new Metodopago();

        metodoPago.setNombre(dto.getNombre());
        metodoPago.setDescripcion(dto.getDescripcion());

        return repository.save(metodoPago);
    }

    public Metodopago actualizar(Integer id, MetodopagoDTO dto) {

        logger.info("Actualizando método de pago");

        Metodopago metodoPago = buscarPorId(id);

        metodoPago.setNombre(dto.getNombre());
        metodoPago.setDescripcion(dto.getDescripcion());

        return repository.save(metodoPago);
    }

    public void eliminar(Integer id) {

        logger.info("Eliminando método de pago");

        repository.deleteById(id);
    }
}
