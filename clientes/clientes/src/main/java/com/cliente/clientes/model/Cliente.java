package com.cliente.clientes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @NotBlank(message = "El rut no puede estar vacío")
    @Size(min = 10, max = 11, message = "El rut debe contener entre 10 y 11 caracteres")
    @Column(unique = true, length = 12, nullable = false)
    private String rut;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe contener entre 2 y 50 caracteres")
    @Column(unique = true, length = 50, nullable = false)
    private String nombre;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(min = 5, max = 100, message = "La dirección debe contener entre 5 y 100 caracteres")
    @Column(unique = false, length = 100, nullable = false)
    private String direccion;

    @NotNull(message = "El teléfono no puede ser nulo")
    private Integer telefono;

    @NotBlank(message = "El correo no puede estar vacío")
    @Size(min = 10, max = 100, message = "El correo debe contener entre 10 y 100 caracteres")
    @Column(unique = false, length = 100, nullable = false)
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 5, max = 20, message = "La contraseña debe contener entre 5 y 20 caracteres")
    @Column(unique = false, length = 20, nullable = false)
    private String contraseña;
}
