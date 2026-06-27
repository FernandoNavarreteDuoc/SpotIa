package com.ubicacion.ubicaciones.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.ubicacion.ubicaciones.controller.ComunaControllerV2;
import com.ubicacion.ubicaciones.model.Comuna;

@Component
public class ComunaModelAssembler implements RepresentationModelAssembler<Comuna, EntityModel<Comuna>>  {
    @Override
    public EntityModel<Comuna> toModel (Comuna comuna){
        return EntityModel.of(comuna,
            linkTo(methodOn(ComunaControllerV2.class).buscar(comuna.getIdComuna())).withSelfRel(),
            linkTo(methodOn(ComunaControllerV2.class).listar()).withRel("comunas"));
    }

}
