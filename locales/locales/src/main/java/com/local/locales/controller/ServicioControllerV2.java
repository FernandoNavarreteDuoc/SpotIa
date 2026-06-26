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

import com.local.locales.DTO.servicioDTO;
import com.local.locales.assemblers.ServicioModelAssembler;
import com.local.locales.model.servicio;
import com.local.locales.service.ServicioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/servicios")
public class ServicioControllerV2 {

    private final ServicioService service;

    @Autowired
    private ServicioModelAssembler assembler;


    public ServicioControllerV2(ServicioService service) {

        this.service = service;
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<servicio>>  listar() {
        List<EntityModel<servicio>> servicios = service.listar().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(servicios,
                linkTo(methodOn(ServicioControllerV2.class).listar()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<servicio> buscar(@PathVariable Integer id) {
        servicio servicio = service.buscarPorId(id);
        return assembler.toModel(servicio);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<servicio>> guardar(@Valid @RequestBody servicioDTO dto) {
        servicio newServicio = service.guardar(dto);
        return ResponseEntity
            .created(linkTo(methodOn(ServicioControllerV2.class).buscar(newServicio.getIdServicio())).toUri())
            .body(assembler.toModel(newServicio));
    }

    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<servicio>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody servicioDTO dto) {

            servicio servicio = service.actualizar(id, dto);
            return ResponseEntity.ok(assembler.toModel(servicio));
    } 

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
