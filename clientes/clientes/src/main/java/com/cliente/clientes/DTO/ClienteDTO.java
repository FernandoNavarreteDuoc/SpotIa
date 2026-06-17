package com.cliente.clientes.DTO;

import lombok.Data;

@Data
public class ClienteDTO {
    private String rut;
    private String nombre;
    private String direccion;
    private Integer telefono;
    private String correo;
    private String contraseña;
    private ReservaExternaDTO reserva;

}
