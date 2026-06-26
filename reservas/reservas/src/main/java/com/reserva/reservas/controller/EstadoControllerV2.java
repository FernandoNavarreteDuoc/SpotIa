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


import com.reserva.reservas.DTO.EstadoDTO;
import com.reserva.reservas.assemblers.EstadoModelAssembler;
import com.reserva.reservas.model.Estado;
import com.reserva.reservas.service.EstadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/estados")
public class EstadoControllerV2 {

    @Autowired
    private EstadoModelAssembler assembler;

    private final EstadoService service;

    public EstadoControllerV2(EstadoService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Estado>> listar() {
        List<EntityModel<Estado>> estados = service.listar().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(estados,
                linkTo(methodOn(EstadoControllerV2.class).listar()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Estado> buscar(@PathVariable Integer id) {
        Estado estado = service.buscarPorId(id);
        return assembler.toModel(estado);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Estado>> guardar(@Valid @RequestBody EstadoDTO dto) {
        Estado newEstado = service.guardar(dto);
        return ResponseEntity
            .created(linkTo(methodOn(EstadoControllerV2.class).buscar(newEstado.getIdEstado())).toUri())
            .body(assembler.toModel(newEstado));
    }

    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Estado>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody EstadoDTO dto) {
            Estado estado = service.actualizar(id, dto);
            return ResponseEntity.ok(assembler.toModel(estado));
    }

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
