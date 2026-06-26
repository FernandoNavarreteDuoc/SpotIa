package com.local.locales.DTO;

import lombok.Data;

@Data
public class servicioDTO {

    private Integer idServicio;
    private String nombre;
    private String descripcion;
    private Integer precio;

    private ReservaExternaDTO reserva;

}