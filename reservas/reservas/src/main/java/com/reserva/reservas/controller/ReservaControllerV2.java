package com.reserva.reservas.controller;

import java.util.stream.Collectors;

import java.util.List;
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

import com.reserva.reservas.DTO.ReservaDTO;
import com.reserva.reservas.assemblers.ReservaModelAssembler;
import com.reserva.reservas.model.Reserva;
import com.reserva.reservas.service.ReservaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/reservas")
public class ReservaControllerV2 {

    @Autowired
    private ReservaModelAssembler assembler;

    private final ReservaService service;

    public ReservaControllerV2(ReservaService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Reserva>> listar() {
        List<EntityModel<Reserva>> reservas = service.listar().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(reservas,
                linkTo(methodOn(ReservaControllerV2.class).listar()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Reserva> buscar(@PathVariable Integer id) {
        Reserva reserva = service.buscarPorId(id);
        return assembler.toModel(reserva);
    }

    @GetMapping("/buscarporcliente/{rutCliente}")
    public ResponseEntity<ReservaDTO> buscarPorCliente(
            @PathVariable String rutCliente) {
        ReservaDTO dto = service.buscarPorCliente(rutCliente);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscarporlocal/{idLocal}")
    public ResponseEntity<ReservaDTO> buscarPorLocal(
            @PathVariable Integer idLocal) {
        ReservaDTO dto = service.buscarPorLocal(idLocal);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscarporservicio/{idServicio}")
    public ResponseEntity<ReservaDTO> buscarPorServicio(
            @PathVariable Integer idServicio) {
        ReservaDTO dto = service.buscarPorServicio(idServicio);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Reserva>> guardar(@Valid @RequestBody ReservaDTO dto) {
        Reserva newReserva = service.guardar(dto);
        return ResponseEntity
            .created(linkTo(methodOn(ReservaControllerV2.class).buscar(newReserva.getIdReserva())).toUri())
            .body(assembler.toModel(newReserva));
    }

    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Reserva>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody ReservaDTO dto) {

            Reserva reserva= service.actualizar(id, dto);
            return ResponseEntity.ok(assembler.toModel(reserva));
    }

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Reserva>>  eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
