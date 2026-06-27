package com.ubicacion.ubicaciones.service;

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

import com.ubicacion.ubicaciones.DTO.ubicacionDTO;
import com.ubicacion.ubicaciones.model.Ubicacion;
import com.ubicacion.ubicaciones.repository.UbicacionRepository;

@ExtendWith(MockitoExtension.class)
public class UbicacionServiceTest {

    @Mock
    private UbicacionRepository repository;

    @InjectMocks
    private UbicacionService service;

    @BeforeEach
    void setUp() { MockitoAnnotations.openMocks(this); }

    private Ubicacion crearUbicacion() {
        Ubicacion u = new Ubicacion();
        u.setIdUbicacion(1);
        u.setDireccion("Calle Principal 123");
        u.setReferencia("Esquina con Av. Libertador");
        u.setIdComuna(1);
        return u;
    }

    @Test
    void testListar() {
        when(repository.findAll()).thenReturn(List.of(crearUbicacion()));
        List<Ubicacion> resultado = service.listar();
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
    }

    @Test
    void testBuscarPorId() {
        when(repository.findById(1)).thenReturn(Optional.of(crearUbicacion()));
        Ubicacion resultado = service.buscarPorId(1);
        assertNotNull(resultado);
        assertEquals("Calle Principal 123", resultado.getDireccion());
        verify(repository, times(1)).findById(1);
    }

    @Test
    void testGuardar() {
        Ubicacion ubicacion = crearUbicacion();
        ubicacionDTO dto = new ubicacionDTO();
        dto.setDireccion("Calle Principal 123");
        dto.setReferencia("Esquina con Av. Libertador");
        dto.setIdComuna(1);
        when(repository.save(any(Ubicacion.class))).thenReturn(ubicacion);
        Ubicacion resultado = service.guardar(dto);
        assertNotNull(resultado);
        assertEquals(1, resultado.getIdComuna());
    }

    @Test
    void testEliminar() {
        doNothing().when(repository).deleteById(1);
        service.eliminar(1);
        verify(repository, times(1)).deleteById(1);
    }
}