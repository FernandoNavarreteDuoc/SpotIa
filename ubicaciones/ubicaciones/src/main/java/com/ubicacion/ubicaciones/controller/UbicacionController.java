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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/ubicaciones")
public class UbicacionController {

    private final UbicacionService service;

    public UbicacionController(UbicacionService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Ubicacion>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ubicacion> buscar(
            @PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Ubicacion> guardar(
            @Valid @RequestBody ubicacionDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ubicacion> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody ubicacionDTO dto) {

        return ResponseEntity.ok(
                service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}