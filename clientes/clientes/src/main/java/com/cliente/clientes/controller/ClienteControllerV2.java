package com.cliente.clientes.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.cliente.clientes.DTO.ClienteDTO;
import com.cliente.clientes.assemblers.ClienteModelAssembler;
import com.cliente.clientes.model.Cliente;
import com.cliente.clientes.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/clientes")
@Tag(name = "Clientes V2", description = "Gestión de clientes con HATEOAS")
public class ClienteControllerV2 {

    private final ClienteService service;
    private final ClienteModelAssembler assembler;

    public ClienteControllerV2(ClienteService service, ClienteModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Listar clientes con HATEOAS")
    public CollectionModel<EntityModel<Cliente>> getAllClientes() {
        List<EntityModel<Cliente>> clientes = service.listar().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(clientes,
                linkTo(methodOn(ClienteControllerV2.class).getAllClientes()).withSelfRel());
    }

    @GetMapping(value = "/{rut}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Buscar cliente por RUT con HATEOAS")
    public EntityModel<Cliente> getClienteByRut(@PathVariable String rut) {
        Cliente cliente = service.buscarPorRut(rut);
        return assembler.toModel(cliente);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Crear cliente con HATEOAS")
    public ResponseEntity<EntityModel<Cliente>> guardar(@Valid @RequestBody ClienteDTO dto) {
        Cliente newCliente = service.guardar(dto);
        return ResponseEntity
                .created(linkTo(methodOn(ClienteControllerV2.class).getClienteByRut(newCliente.getRut())).toUri())
                .body(assembler.toModel(newCliente));
    }

    @PutMapping(value = "/{rut}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Actualizar cliente con HATEOAS")
    public ResponseEntity<EntityModel<Cliente>> actualizar(
            @PathVariable String rut,
            @Valid @RequestBody ClienteDTO dto) {
        Cliente cliente = service.actualizar(rut, dto);
        return ResponseEntity.ok(assembler.toModel(cliente));
    }

    @DeleteMapping(value = "/{rut}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Eliminar cliente con HATEOAS")
    public ResponseEntity<?> deleteCliente(@PathVariable String rut) {
        service.eliminar(rut);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{rut}/detalle", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Detalle cliente con reserva - HATEOAS")
    public ResponseEntity<ClienteDTO> detalle(@PathVariable String rut) {
        Cliente cliente = service.buscarPorRut(rut);
        return ResponseEntity.ok(service.convertirADTO(cliente));
    }
}