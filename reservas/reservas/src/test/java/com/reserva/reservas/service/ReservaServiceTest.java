package com.reserva.reservas.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.reserva.reservas.DTO.ReservaDTO;
import com.reserva.reservas.model.Reserva;
import com.reserva.reservas.repository.ReservaRepository;

@ExtendWith(MockitoExtension.class)
public class ReservaServiceTest {

    @Mock
    private ReservaRepository repository;

    @InjectMocks
    private ReservaService service;

    @BeforeEach
    void setUp() { MockitoAnnotations.openMocks(this); }

    private Reserva crearReserva() {
        Reserva r = new Reserva();
        r.setIdReserva(1);
        r.setFechaReserva(LocalDate.of(2026, 7, 1));
        r.setHoraReserva(LocalTime.of(19, 0));
        r.setCantidadPersonas(4);
        r.setTotal(200000);
        r.setRutCliente("12345678-9");
        r.setIdLocal(1);
        r.setIdServicio(1);
        r.setIdMetodoPago(1);
        r.setIdEstado(1);
        return r;
    }

    @Test
    void testListar() {
        // Given
        when(repository.findAll()).thenReturn(List.of(crearReserva()));
        // When
        List<Reserva> resultado = service.listar();
        // Then
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
    }

    @Test
    void testBuscarPorId() {
        // Given
        when(repository.findById(1)).thenReturn(Optional.of(crearReserva()));
        // When
        Reserva resultado = service.buscarPorId(1);
        // Then
        assertNotNull(resultado);
        assertEquals("12345678-9", resultado.getRutCliente());
        verify(repository, times(1)).findById(1);
    }

    @Test
    void testGuardar() {
        // Given
        Reserva reserva = crearReserva();
        ReservaDTO dto = new ReservaDTO();
        dto.setFechaReserva(LocalDate.of(2026, 7, 1));
        dto.setHoraReserva(LocalTime.of(19, 0));
        dto.setCantidadPersonas(4);
        dto.setTotal(200000);
        dto.setRutCliente("12345678-9");
        dto.setIdLocal(1);
        dto.setIdServicio(1);
        dto.setIdMetodoPago(1);
        dto.setIdEstado(1);
        when(repository.save(any(Reserva.class))).thenReturn(reserva);
        // When
        Reserva resultado = service.guardar(dto);
        assertNotNull(resultado);
        assertEquals(200000, resultado.getTotal());
    }

    @Test
    void testBuscarPorCliente() {
        when(repository.findByRutCliente("12345678-9")).thenReturn(crearReserva());
        ReservaDTO dto = service.buscarPorCliente("12345678-9");
        assertNotNull(dto);
        assertEquals("12345678-9", dto.getRutCliente());
    }

    @Test
    void testBuscarPorClienteNoExiste() {
        when(repository.findByRutCliente("99999999-9")).thenReturn(null);
        ReservaDTO dto = service.buscarPorCliente("99999999-9");
        assertNull(dto);
    }

    @Test
    void testEliminar() {
        doNothing().when(repository).deleteById(1);
        service.eliminar(1);
        verify(repository, times(1)).deleteById(1);
    }
}