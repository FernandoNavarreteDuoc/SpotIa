package com.cliente.clientes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.clientes.DTO.ClienteDTO;
import com.cliente.clientes.model.Cliente;
import com.cliente.clientes.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clientes")
@Tag(name = "Clientes", description = "Gestión de clientes de SpotIa")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todos los clientes", description = "Retorna lista completa de clientes registrados")
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{rut}")
    @Operation(summary = "Buscar cliente por RUT", description = "Retorna un cliente según su RUT")
    public ResponseEntity<Cliente> buscar(@PathVariable String rut) {
        return ResponseEntity.ok(service.buscarPorRut(rut));
    }

    @PostMapping
    @Operation(summary = "Crear cliente", description = "Registra un nuevo cliente en el sistema")
    public ResponseEntity<Cliente> guardar(@Valid @RequestBody ClienteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dto));
    }

    @PutMapping("/{rut}")
    @Operation(summary = "Actualizar cliente", description = "Modifica los datos de un cliente existente")
    public ResponseEntity<Cliente> actualizar(@PathVariable String rut, @Valid @RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(service.actualizar(rut, dto));
    }

    @DeleteMapping("/{rut}")
    @Operation(summary = "Eliminar cliente", description = "Elimina un cliente por su RUT")
    public ResponseEntity<Void> eliminar(@PathVariable String rut) {
        service.eliminar(rut);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{rut}/detalle")
    @Operation(summary = "Detalle completo del cliente", description = "Retorna cliente con su última reserva asociada")
    public ResponseEntity<ClienteDTO> detalle(@PathVariable String rut) {
        Cliente cliente = service.buscarPorRut(rut);
        return ResponseEntity.ok(service.convertirADTO(cliente));
    }
}