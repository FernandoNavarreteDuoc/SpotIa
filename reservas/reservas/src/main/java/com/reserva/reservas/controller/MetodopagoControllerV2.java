package com.reserva.reservas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.reserva.reservas.DTO.MetodopagoDTO;
import com.reserva.reservas.assemblers.MetodopagoModelAssembler;
import com.reserva.reservas.model.Metodopago;
import com.reserva.reservas.service.MetodopagoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/metodospago")
public class MetodopagoControllerV2 {

    @Autowired
    private MetodopagoModelAssembler assembler;

    private final MetodopagoService service;

    public MetodopagoControllerV2(MetodopagoService service) {

        this.service = service;
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Metodopago>> listar() {
        List<EntityModel<Metodopago>> metodospago = service.listar().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(metodospago,
                linkTo(methodOn(MetodopagoControllerV2.class).listar()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Metodopago> buscar(@PathVariable Integer id) {
        Metodopago metodopago = service.buscarPorId(id);
        return assembler.toModel(metodopago);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Metodopago>> guardar(@Valid @RequestBody MetodopagoDTO dto) {
        Metodopago newMetodopago = service.guardar(dto);
        return ResponseEntity
            .created(linkTo(methodOn(MetodopagoControllerV2.class).buscar(newMetodopago.getIdMetodoPago())).toUri())
            .body(assembler.toModel(newMetodopago));
    }

    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Metodopago>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody MetodopagoDTO dto) {

            Metodopago metodopago= service.actualizar(id, dto);
            return ResponseEntity.ok(assembler.toModel(metodopago));
    }

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Metodopago>> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
