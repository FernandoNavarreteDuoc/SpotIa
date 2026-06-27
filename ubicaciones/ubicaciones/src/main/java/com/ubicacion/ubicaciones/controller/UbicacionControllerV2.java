package com.ubicacion.ubicaciones.controller;

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

import com.ubicacion.ubicaciones.DTO.ubicacionDTO;
import com.ubicacion.ubicaciones.assemblers.UbicacionModelAssembler;
import com.ubicacion.ubicaciones.model.Ubicacion;
import com.ubicacion.ubicaciones.service.UbicacionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/ubicaciones")
public class UbicacionControllerV2 {

    @Autowired
    private UbicacionModelAssembler assembler;

    private final UbicacionService service;

    public UbicacionControllerV2(UbicacionService service) {

        this.service = service;
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Ubicacion>> listar() {
        List<EntityModel<Ubicacion>> ubicaciones = service.listar().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(ubicaciones,
            linkTo(methodOn(UbicacionControllerV2.class).listar()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Ubicacion> buscar(@PathVariable Integer id) {
        Ubicacion ubicacion = service.buscarPorId(id);
        return assembler.toModel(ubicacion);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Ubicacion>> guardar(@Valid @RequestBody ubicacionDTO dto) {
        Ubicacion newUbicacion = service.guardar(dto);
        return ResponseEntity
            .created(linkTo(methodOn(UbicacionControllerV2.class).buscar(newUbicacion.getIdUbicacion())).toUri())
            .body(assembler.toModel(newUbicacion));
    }

    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Ubicacion>> actualizar(
        @PathVariable Integer id,
        @Valid @RequestBody ubicacionDTO dto) {
        Ubicacion ubicacion = service.actualizar(id, dto);
        return ResponseEntity.ok(assembler.toModel(ubicacion));
    }

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Ubicacion>> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
