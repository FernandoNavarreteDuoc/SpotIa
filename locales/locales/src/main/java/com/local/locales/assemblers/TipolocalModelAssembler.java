package com.local.locales.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.local.locales.controller.TipolocalControllerV2;
import com.local.locales.model.Tipolocal;


@Component
public class TipolocalModelAssembler implements RepresentationModelAssembler<Tipolocal, EntityModel<Tipolocal>> {
    @Override
    public EntityModel<Tipolocal> toModel (Tipolocal tipolocal){
        return EntityModel.of(tipolocal,
            linkTo(methodOn(TipolocalControllerV2.class).buscar(tipolocal.getIdTipoLocal())).withSelfRel(),
            linkTo(methodOn(TipolocalControllerV2.class).listar()).withRel("tiposlocal"));
    }
}
