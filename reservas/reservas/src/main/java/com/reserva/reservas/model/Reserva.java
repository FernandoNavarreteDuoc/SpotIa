package com.reserva.reservas.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @NotNull(message = "La fecha no puede ser nula")
    @FutureOrPresent(message = "La fecha debe ser actual o futura")
    private LocalDate fechaReserva;

    @NotNull(message = "La hora no puede ser nula")
    private LocalTime horaReserva;

    @NotNull(message = "La cantidad de personas no puede ser nula")
    @Min(value = 1, message = "Debe haber al menos una persona")
    private Integer cantidadPersonas;

    @NotNull(message = "El total no puede ser nulo")
    @Min(value = 1, message = "El total debe ser mayor a 0")
    private Integer total;

    @NotBlank(message = "El rut del cliente no puede ser vacío")
    @Column(name = "rut_cliente", nullable = false)
    private String rutCliente;

    @NotNull(message = "El id del local no puede ser nulo")
    @Column(name = "id_local", nullable = false)
    private Integer idLocal;

    @NotNull(message = "El id del servicio no puede ser nulo")
    @Column(name = "id_servicio", nullable = false)
    private Integer idServicio;

    @NotNull(message = "El id del método de pago no puede ser nulo")
    @Column(name = "id_metodo_pago", nullable = false)
    private Integer idMetodoPago;

    @NotNull(message = "El id del estado no puede ser nulo")
    @Column(name = "id_estado", nullable = false)
    private Integer idEstado;
}