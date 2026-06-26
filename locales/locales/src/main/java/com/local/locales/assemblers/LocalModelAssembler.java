package com.local.locales.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.local.locales.controller.LocalControllerV2;
import com.local.locales.model.Local;

@Component
public class LocalModelAssembler implements RepresentationModelAssembler<Local, EntityModel<Local>> {

    @Override
    public EntityModel<Local> toModel (Local local){
        return EntityModel.of(local,
            linkTo(methodOn(LocalControllerV2.class).buscar(local.getIdLocal())).withSelfRel(),
            linkTo(methodOn(LocalControllerV2.class).listar()).withRel("locales"));
    }

}
