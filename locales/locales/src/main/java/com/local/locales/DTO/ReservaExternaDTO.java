package com.local.locales.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class ReservaExternaDTO {
    private Integer idReserva;
    private LocalDate fechaReserva;
    private LocalTime horaReserva;
    private Integer cantidadPersonas;
    private Integer total;

    private String rutCliente;
    private Integer idLocal;
    private Integer idServicio;
    private Integer idMetodoPago;
    private Integer idEstado;


}
