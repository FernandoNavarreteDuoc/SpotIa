package com.cliente.clientes.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDTO {
    private String rut;
    private String nombre;
    private String direccion;
    private Integer telefono;
    private String correo;
    private String contraseña;
    private ReservaExternaDTO reserva;

}
