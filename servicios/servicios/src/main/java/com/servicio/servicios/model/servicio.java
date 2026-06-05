package com.servicio.servicios.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;     
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe contener entre 3 y 50 caracteres")
    @Column(unique = false, length = 50, nullable = false)
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 5, max = 150, message = "La descripción debe contener entre 5 y 150 caracteres")
    @Column(unique = false, length = 150, nullable = false)
    private String descripcion;

    @NotNull(message = "El precio no puede ser nulo")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private Integer precio;

    @OneToMany(mappedBy = "servicio")
    @ToString.Exclude
    @JsonIgnore
    private List<Reservas> reservas;

    @ManyToMany(mappedBy = "servicios")
    @JsonIgnore
    private List<Local> locales;

}