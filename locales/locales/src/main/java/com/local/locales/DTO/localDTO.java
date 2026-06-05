package com.local.locales.DTO;

import lombok.Data;

@Data
public class localDTO {

    private Integer idLocal;
    private String nombre;
    private String descripcion;
    private Integer capacidad;
    private Integer idTipoLocal;
    private Integer idUbicacion;

}