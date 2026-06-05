package com.tipolocal.tiposlocales.controller;

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

import com.tipolocal.tiposlocales.DTO.tipolocalDTO;
import com.tipolocal.tiposlocales.model.Tipolocal;
import com.tipolocal.tiposlocales.service.TipolocalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tipo_local")
public class TipolocalController {

    private final TipolocalService service;

    public TipolocalController(TipolocalService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Tipolocal>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipolocal> buscar(
            @PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Tipolocal> guardar(
            @Valid @RequestBody tipolocalDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipolocal> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody tipolocalDTO dto) {

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