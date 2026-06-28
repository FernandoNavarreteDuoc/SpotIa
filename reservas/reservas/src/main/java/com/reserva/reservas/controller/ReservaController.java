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

import com.reserva.reservas.DTO.ReservaDTO;
import com.reserva.reservas.model.Reserva;
import com.reserva.reservas.service.ReservaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/reservas")
@Tag(name = "Reservas", description = "Gestión de reservas de SpotIa")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todas las reservas", description = "Retorna lista completa de reservas")
    public ResponseEntity<List<Reserva>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar reserva por ID", description = "Retorna una reserva según su ID")
    public ResponseEntity<Reserva> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/buscarporcliente/{rutCliente}")
    @Operation(summary = "Buscar reserva por cliente", description = "Retorna la reserva asociada a un RUT de cliente")
    public ResponseEntity<ReservaDTO> buscarPorCliente(@PathVariable String rutCliente) {
        ReservaDTO dto = service.buscarPorCliente(rutCliente);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscarporlocal/{idLocal}")
    @Operation(summary = "Buscar reserva por local", description = "Retorna la reserva asociada a un ID de local")
    public ResponseEntity<ReservaDTO> buscarPorLocal(@PathVariable Integer idLocal) {
        ReservaDTO dto = service.buscarPorLocal(idLocal);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscarporservicio/{idServicio}")
    @Operation(summary = "Buscar reserva por servicio", description = "Retorna la reserva asociada a un ID de servicio")
    public ResponseEntity<ReservaDTO> buscarPorServicio(@PathVariable Integer idServicio) {
        ReservaDTO dto = service.buscarPorServicio(idServicio);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @Operation(summary = "Crear reserva", description = "Registra una nueva reserva en el sistema")
    public ResponseEntity<Reserva> guardar(@Valid @RequestBody ReservaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar reserva", description = "Modifica los datos de una reserva existente")
    public ResponseEntity<Reserva> actualizar(@PathVariable Integer id, @Valid @RequestBody ReservaDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar reserva", description = "Elimina una reserva por su ID")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}