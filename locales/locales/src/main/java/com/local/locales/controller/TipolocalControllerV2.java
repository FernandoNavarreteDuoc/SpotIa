package com.local.locales.controller;

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

import com.local.locales.DTO.tipolocalDTO;
import com.local.locales.assemblers.TipolocalModelAssembler;
import com.local.locales.model.Tipolocal;
import com.local.locales.service.TipolocalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/tipo_local")
public class TipolocalControllerV2 {

    private final TipolocalService service;

    @Autowired
    private TipolocalModelAssembler assembler;


    public TipolocalControllerV2(TipolocalService service) {

        this.service = service;
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Tipolocal>> listar() {
        List<EntityModel<Tipolocal>> tiposlocal = service.listar().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(tiposlocal,
                linkTo(methodOn(TipolocalControllerV2.class).listar()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Tipolocal> buscar(@PathVariable Integer id) {
        Tipolocal tipolocal = service.buscarPorId(id);
        return assembler.toModel(tipolocal);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Tipolocal>> guardar(@Valid @RequestBody tipolocalDTO dto) {
        Tipolocal newTipolocal = service.guardar(dto);
        return ResponseEntity
            .created(linkTo(methodOn(ServicioControllerV2.class).buscar(newTipolocal.getIdTipoLocal())).toUri())
            .body(assembler.toModel(newTipolocal));
    }

    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Tipolocal>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody tipolocalDTO dto) {
        
        Tipolocal tipolocal = service.actualizar(id, dto);
        return ResponseEntity.ok(assembler.toModel(tipolocal));
    }

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
