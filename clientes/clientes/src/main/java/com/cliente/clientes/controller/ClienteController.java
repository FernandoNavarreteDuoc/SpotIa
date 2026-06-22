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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
private final ClienteService service;

    
    public ClienteController(ClienteService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{rut}")
    public ResponseEntity<Cliente> buscar(
            @PathVariable String rut) {

        return ResponseEntity.ok(service.buscarPorRut(rut));
    }

    @PostMapping
    public ResponseEntity<Cliente> guardar(
            @Valid @RequestBody ClienteDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping("/{rut}")
    public ResponseEntity<Cliente> actualizar(
            @PathVariable String rut,
            @Valid @RequestBody ClienteDTO dto) {

        return ResponseEntity.ok(
                service.actualizar(rut, dto));
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<Void> eliminar(
            @PathVariable String rut) {

        service.eliminar(rut);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{rut}/detalle")
    public ResponseEntity<ClienteDTO> detalle(
            @PathVariable String rut) {

        Cliente cliente = service.buscarPorRut(rut);
        return ResponseEntity.ok(service.convertirADTO(cliente));
    }
}
