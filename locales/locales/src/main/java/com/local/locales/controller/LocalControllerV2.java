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

import com.local.locales.DTO.localDTO;
import com.local.locales.assemblers.LocalModelAssembler;
import com.local.locales.model.Local;
import com.local.locales.service.LocalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/locales")
public class LocalControllerV2 {

    @Autowired
    private LocalModelAssembler assembler;

    private final LocalService service;

    public LocalControllerV2(LocalService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Local>>  listar() {
        List<EntityModel<Local>> locales = service.listar().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(locales,
                linkTo(methodOn(LocalControllerV2.class).listar()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public  EntityModel<Local>  buscar(@PathVariable Integer id) {
        Local local = service.buscarPorId(id);
        return assembler.toModel(local);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Local>> guardar(@Valid @RequestBody localDTO dto) {
        Local newLocal = service.guardar(dto);
        return ResponseEntity
            .created(linkTo(methodOn(LocalControllerV2.class).buscar(newLocal.getIdLocal())).toUri())
            .body(assembler.toModel(newLocal));
    }

    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Local>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody localDTO dto) {
            Local local = service.actualizar(id, dto);
            return ResponseEntity.ok(assembler.toModel(local));
    }

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
