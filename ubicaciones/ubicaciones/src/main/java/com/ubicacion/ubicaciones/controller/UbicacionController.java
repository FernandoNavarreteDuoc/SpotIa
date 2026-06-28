package com.ubicacion.ubicaciones.controller;

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

import com.ubicacion.ubicaciones.DTO.ubicacionDTO;
import com.ubicacion.ubicaciones.model.Ubicacion;
import com.ubicacion.ubicaciones.service.UbicacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/ubicaciones")
@Tag(name = "Ubicaciones", description = "Gestión de ubicaciones de SpotIa")
public class UbicacionController {

    private final UbicacionService service;

    public UbicacionController(UbicacionService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todas las ubicaciones", description = "Retorna lista completa de ubicaciones")
    public ResponseEntity<List<Ubicacion>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar ubicación por ID", description = "Retorna una ubicación según su ID")
    public ResponseEntity<Ubicacion> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear ubicación", description = "Registra una nueva ubicación en el sistema")
    public ResponseEntity<Ubicacion> guardar(@Valid @RequestBody ubicacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar ubicación", description = "Modifica los datos de una ubicación existente")
    public ResponseEntity<Ubicacion> actualizar(@PathVariable Integer id, @Valid @RequestBody ubicacionDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar ubicación", description = "Elimina una ubicación por su ID")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
