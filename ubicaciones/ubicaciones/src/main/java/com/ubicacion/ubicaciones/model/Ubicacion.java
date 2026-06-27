package com.ubicacion.ubicaciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ubicaciones")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUbicacion;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(min = 5, max = 100, message = "La dirección debe contener entre 5 y 100 caracteres")
    @Column(unique = false, length = 100, nullable = false)
    private String direccion;

    @NotBlank(message = "La referencia no puede estar vacía")
    @Size(min = 3, max = 100, message = "La referencia debe contener entre 3 y 100 caracteres")
    @Column(unique = false, length = 100, nullable = false)
    private String referencia;

    @NotNull(message = "El id de comuna no puede ser nulo")
    @Column(name = "id_comuna", nullable = false)
    private Integer idComuna;
}