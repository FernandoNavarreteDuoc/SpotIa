package com.cliente.clientes.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.clientes.DTO.ClienteDTO;
import com.cliente.clientes.assemblers.ClienteModelAssembler;
import com.cliente.clientes.model.Cliente;
import com.cliente.clientes.service.ClienteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/clientes")
public class ClienteControllerV2 {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteModelAssembler assembler;

    
    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<List<Cliente>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping(value = "/{rut}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Cliente> buscar(
            @PathVariable String rut) {

        return ResponseEntity.ok(service.buscarPorRut(rut));
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Cliente> guardar(
            @Valid @RequestBody ClienteDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping(value = "/{rut}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Cliente> actualizar(
            @PathVariable String rut,
            @Valid @RequestBody ClienteDTO dto) {

        return ResponseEntity.ok(
                service.actualizar(rut, dto));
    }

    @DeleteMapping(value = "/{rut}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Void> eliminar(
            @PathVariable String rut) {

        service.eliminar(rut);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{rut}/detalle", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<ClienteDTO> detalle(
            @PathVariable String rut) {

        Cliente cliente = service.buscarPorRut(rut);
        return ResponseEntity.ok(service.convertirADTO(cliente));
    }
}
