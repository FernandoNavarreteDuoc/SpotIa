package com.reserva.reservas.controller;


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

import com.reserva.reservas.DTO.MetodopagoDTO;
import com.reserva.reservas.model.Metodopago;
import com.reserva.reservas.service.MetodopagoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/metodopago")
public class MetodopagoController {

    private final MetodopagoService service;

    public MetodopagoController(MetodopagoService service) {

        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Metodopago>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metodopago> buscar(
            @PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Metodopago> guardar(
            @Valid @RequestBody MetodopagoDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Metodopago> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody MetodopagoDTO dto) {

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
