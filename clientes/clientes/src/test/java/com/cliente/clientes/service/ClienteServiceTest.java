package com.cliente.clientes.service;

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

import com.cliente.clientes.DTO.ClienteDTO;
import com.cliente.clientes.model.Cliente;
import com.cliente.clientes.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository repository;

    @Mock
    private WebClient.Builder webClientBuilder;

    @InjectMocks
    private ClienteService service;

    @BeforeEach
    void setUp() { MockitoAnnotations.openMocks(this); }

    private Cliente crearCliente() {
        Cliente c = new Cliente();
        c.setRut("12345678-9");
        c.setNombre("Juan Pérez");
        c.setDireccion("Av. Principal 123");
        c.setTelefono(987654321);
        c.setCorreo("juan@correo.com");
        c.setContraseña("pass123");
        return c;
    }

    @Test
    void testListar() {
        when(repository.findAll()).thenReturn(List.of(crearCliente()));
        List<Cliente> resultado = service.listar();
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
    }

    @Test
    void testBuscarPorRut() {
        when(repository.findById("12345678-9")).thenReturn(Optional.of(crearCliente()));
        Cliente resultado = service.buscarPorRut("12345678-9");
        assertNotNull(resultado);
        assertEquals("Juan Pérez", resultado.getNombre());
        verify(repository, times(1)).findById("12345678-9");
    }

    @Test
    void testGuardar() {
        // Given
        Cliente cliente = crearCliente();
        ClienteDTO dto = new ClienteDTO();
        dto.setRut("12345678-9");
        dto.setNombre("Juan Pérez");
        dto.setDireccion("Av. Principal 123");
        dto.setTelefono(987654321);
        dto.setCorreo("juan@correo.com");
        dto.setContraseña("pass123");
        when(repository.save(any(Cliente.class))).thenReturn(cliente);
        // When
        Cliente resultado = service.guardar(dto);
        // Then
        assertNotNull(resultado);
        assertEquals("Juan Pérez", resultado.getNombre());
    }

    @Test
    void testActualizar() {
        // Given
        Cliente cliente = crearCliente();
        ClienteDTO dto = new ClienteDTO();
        dto.setNombre("Juan Modificado");
        dto.setDireccion("Calle Nueva 456");
        dto.setTelefono(111222333);
        dto.setCorreo("nuevo@correo.com");
        dto.setContraseña("newpass");
        when(repository.findById("12345678-9")).thenReturn(Optional.of(cliente));
        when(repository.save(any(Cliente.class))).thenReturn(cliente);
        Cliente resultado = service.actualizar("12345678-9", dto);
        assertNotNull(resultado);
        verify(repository, times(1)).save(any(Cliente.class));
    }

    @Test
    void testEliminar() {
        doNothing().when(repository).deleteById("12345678-9");
        service.eliminar("12345678-9");
        verify(repository, times(1)).deleteById("12345678-9");
    }
}