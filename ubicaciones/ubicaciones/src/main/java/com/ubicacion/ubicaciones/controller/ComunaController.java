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

import com.ubicacion.ubicaciones.DTO.ComunaDTO;
import com.ubicacion.ubicaciones.model.Comuna;
import com.ubicacion.ubicaciones.service.ComunaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/comunas")
public class ComunaController {
    private final ComunaService service;

    public ComunaController(ComunaService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Comuna>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> buscar(
            @PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Comuna> guardar(
            @Valid @RequestBody ComunaDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comuna> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody ComunaDTO dto) {

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
