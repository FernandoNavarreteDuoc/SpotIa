package com.reserva.reservas.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.reserva.reservas.controller.ReservaControllerV2;
import com.reserva.reservas.model.Reserva;

@Component
public class ReservaModelAssembler implements RepresentationModelAssembler<Reserva, EntityModel<Reserva>> {
    @Override
    public EntityModel<Reserva> toModel (Reserva reserva){
        return EntityModel.of(reserva,
            linkTo(methodOn(ReservaControllerV2.class).buscar(reserva.getIdReserva())).withSelfRel(),
            linkTo(methodOn(ReservaControllerV2.class).listar()).withRel("reservas"));
    }

}
