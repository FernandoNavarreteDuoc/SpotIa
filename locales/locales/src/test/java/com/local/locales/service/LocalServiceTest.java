package com.local.locales.service;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import org.springframework.web.reactive.function.client.WebClient;

import com.local.locales.DTO.localDTO;
import com.local.locales.model.Local;
import com.local.locales.repository.LocalRepository;

@ExtendWith(MockitoExtension.class)
public class LocalServiceTest {

    @Mock
    private LocalRepository repository;

    @Mock
    private WebClient.Builder webClientBuilder;

    @InjectMocks
    private LocalService service;

    @BeforeEach
    void setUp() { MockitoAnnotations.openMocks(this); }

    private Local crearLocal() {
        Local l = new Local();
        l.setIdLocal(1);
        l.setNombre("Le Voleign");
        l.setDescripcion("Comida italiana de calidad");
        l.setCapacidad(100);
        l.setIdTipoLocal(1);
        l.setIdUbicacion(1);
        return l;
    }

    @Test
    void testListar() {
        when(repository.findAll()).thenReturn(List.of(crearLocal()));
        List<Local> resultado = service.listar();
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
    }

    @Test
    void testBuscarPorId() {
        when(repository.findById(1)).thenReturn(Optional.of(crearLocal()));
        Local resultado = service.buscarPorId(1);
        assertNotNull(resultado);
        assertEquals("Le Voleign", resultado.getNombre());
        verify(repository, times(1)).findById(1);
    }

    @Test
    void testGuardar() {
        Local local = crearLocal();
        localDTO dto = new localDTO();
        dto.setNombre("Le Voleign");
        dto.setDescripcion("Comida italiana de calidad");
        dto.setCapacidad(100);
        dto.setIdTipoLocal(1);
        dto.setIdUbicacion(1);
        when(repository.save(any(Local.class))).thenReturn(local);
        Local resultado = service.guardar(dto);        assertNotNull(resultado);
        assertEquals("Le Voleign", resultado.getNombre());
    }

    @Test
    void testEliminar() {
        doNothing().when(repository).deleteById(1);
        service.eliminar(1);
        verify(repository, times(1)).deleteById(1);
    }
}