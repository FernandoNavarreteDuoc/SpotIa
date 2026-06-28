package com.local.locales.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class localDTO {

    private Integer idLocal;
    private String nombre;
    private String descripcion;
    private Integer capacidad;
    private Integer idTipoLocal;
    private Integer idUbicacion;

    private ReservaExternaDTO reserva;

}