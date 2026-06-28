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

import com.local.locales.DTO.servicioDTO;
import com.local.locales.model.servicio;
import com.local.locales.service.ServicioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/servicios")
@Tag(name = "Servicios", description = "Gestión de servicios de SpotIa")
public class ServicioController {

    private final ServicioService service;

    public ServicioController(ServicioService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todos los servicios", description = "Retorna lista completa de servicios")
    public ResponseEntity<List<servicio>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar servicio por ID", description = "Retorna un servicio según su ID")
    public ResponseEntity<servicio> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear servicio", description = "Registra un nuevo servicio en el sistema")
    public ResponseEntity<servicio> guardar(@Valid @RequestBody servicioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar servicio", description = "Modifica los datos de un servicio existente")
    public ResponseEntity<servicio> actualizar(@PathVariable Integer id, @Valid @RequestBody servicioDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar servicio", description = "Elimina un servicio por su ID")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/detalle")
    @Operation(summary = "Detalle completo del servicio", description = "Retorna servicio con su última reserva asociada")
    public ResponseEntity<servicioDTO> detalle(@PathVariable Integer id) {
        servicio s = service.buscarPorId(id);
        return ResponseEntity.ok(service.convertirADTO(s));
    }
}