package com.ubicacion.ubicaciones.controller;

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

import java.util.List;
import java.util.stream.Collectors;

import com.ubicacion.ubicaciones.DTO.regionDTO;
import com.ubicacion.ubicaciones.assemblers.RegionModelAssembler;
import com.ubicacion.ubicaciones.model.Region;
import com.ubicacion.ubicaciones.service.RegionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/regiones")
public class RegionControllerV2 {

    @Autowired
    private RegionModelAssembler assembler;

    private final RegionService service;

    public RegionControllerV2(RegionService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Region>> listar() {
        List<EntityModel<Region>> regiones = service.listar().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(regiones,
            linkTo(methodOn(RegionControllerV2.class).listar()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Region> buscar(@PathVariable Integer id) {
        Region region = service.buscarPorId(id);
        return assembler.toModel(region);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Region>> guardar(@Valid @RequestBody regionDTO dto) {
        Region newRegion = service.guardar(dto);
        return ResponseEntity
            .created(linkTo(methodOn(RegionControllerV2.class).buscar(newRegion.getIdRegion())).toUri())
            .body(assembler.toModel(newRegion));
    }

    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Region>> actualizar(
        @PathVariable Integer id,
        @Valid @RequestBody regionDTO dto) {
        Region region = service.actualizar(id, dto);
        return ResponseEntity.ok(assembler.toModel(region));
    }

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Region>> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
