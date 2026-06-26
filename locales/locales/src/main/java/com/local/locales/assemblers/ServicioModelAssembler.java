package com.local.locales.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.local.locales.controller.ServicioControllerV2;
import com.local.locales.model.servicio;

@Component
public class ServicioModelAssembler implements RepresentationModelAssembler<servicio, EntityModel<servicio>>  {
    @Override
    public EntityModel<servicio> toModel (servicio servicio){
        return EntityModel.of(servicio,
            linkTo(methodOn(ServicioControllerV2.class).buscar(servicio.getIdServicio())).withSelfRel(),
            linkTo(methodOn(ServicioControllerV2.class).listar()).withRel("servicios"));
    }

}
