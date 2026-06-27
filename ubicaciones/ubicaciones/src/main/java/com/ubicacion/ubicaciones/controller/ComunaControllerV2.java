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

import com.ubicacion.ubicaciones.DTO.ComunaDTO;
import com.ubicacion.ubicaciones.assemblers.ComunaModelAssembler;
import com.ubicacion.ubicaciones.model.Comuna;
import com.ubicacion.ubicaciones.service.ComunaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/comunas")
public class ComunaControllerV2 {

    @Autowired
    private ComunaModelAssembler assembler;

    private final ComunaService service;

    public ComunaControllerV2(ComunaService service) {

        this.service = service;
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Comuna>> listar() {
        List<EntityModel<Comuna>> comunas = service.listar().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(comunas,
                linkTo(methodOn(ComunaControllerV2.class).listar()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Comuna> buscar(@PathVariable Integer id) {
        Comuna comuna = service.buscarPorId(id);
        return assembler.toModel(comuna);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Comuna>> guardar(@Valid @RequestBody ComunaDTO dto) {
        Comuna newComuna = service.guardar(dto);
        return ResponseEntity
            .created(linkTo(methodOn(ComunaControllerV2.class).buscar(newComuna.getIdComuna())).toUri())
            .body(assembler.toModel(newComuna));
    }

    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Comuna>> actualizar(
        @PathVariable Integer id,
        @Valid @RequestBody ComunaDTO dto) {
        Comuna comuna = service.actualizar(id, dto);
        return ResponseEntity.ok(assembler.toModel(comuna));
    }

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Comuna>> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
