package com.local.locales.controller;

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

import com.local.locales.DTO.localDTO;
import com.local.locales.model.Local;
import com.local.locales.service.LocalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/locales")
@Tag(name = "Locales", description = "Gestión de locales de SpotIa")
public class LocalController {

    private final LocalService service;

    public LocalController(LocalService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todos los locales", description = "Retorna lista completa de locales")
    public ResponseEntity<List<Local>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar local por ID", description = "Retorna un local según su ID")
    public ResponseEntity<Local> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear local", description = "Registra un nuevo local en el sistema")
    public ResponseEntity<Local> guardar(@Valid @RequestBody localDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar local", description = "Modifica los datos de un local existente")
    public ResponseEntity<Local> actualizar(@PathVariable Integer id, @Valid @RequestBody localDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar local", description = "Elimina un local por su ID")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/detalle")
    @Operation(summary = "Detalle completo del local", description = "Retorna local con su última reserva asociada")
    public ResponseEntity<localDTO> detalle(@PathVariable Integer id) {
        Local local = service.buscarPorId(id);
        return ResponseEntity.ok(service.convertirADTO(local));
    }
}