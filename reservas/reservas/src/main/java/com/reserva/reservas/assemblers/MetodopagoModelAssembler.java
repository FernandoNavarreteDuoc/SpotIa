package com.reserva.reservas.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.reserva.reservas.controller.MetodopagoControllerV2;
import com.reserva.reservas.model.Metodopago;

@Component
public class MetodopagoModelAssembler implements RepresentationModelAssembler<Metodopago, EntityModel<Metodopago>> {
    @Override
    public EntityModel<Metodopago> toModel (Metodopago metodopago){
        return EntityModel.of(metodopago,
            linkTo(methodOn(MetodopagoControllerV2.class).buscar(metodopago.getIdMetodoPago())).withSelfRel(),
            linkTo(methodOn(MetodopagoControllerV2.class).listar()).withRel("metodospago"));
    }

}
