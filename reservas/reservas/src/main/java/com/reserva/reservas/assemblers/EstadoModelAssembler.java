package com.reserva.reservas.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.reserva.reservas.controller.EstadoControllerV2;
import com.reserva.reservas.model.Estado;

@Component
public class EstadoModelAssembler implements RepresentationModelAssembler<Estado, EntityModel<Estado>>  {

    @Override
    public EntityModel<Estado> toModel (Estado estado){
        return EntityModel.of(estado,
            linkTo(methodOn(EstadoControllerV2.class).buscar(estado.getIdEstado())).withSelfRel(),
            linkTo(methodOn(EstadoControllerV2.class).listar()).withRel("estados"));
    }

}
