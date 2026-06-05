package com.servicio.servicios.DTO;

import lombok.Data;

@Data
public class servicioDTO {

    private Integer idServicio;
    private String nombre;
    private String descripcion;
    private Integer precio;

}