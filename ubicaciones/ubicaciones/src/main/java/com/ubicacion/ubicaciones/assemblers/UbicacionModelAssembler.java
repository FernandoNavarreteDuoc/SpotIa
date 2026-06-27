package com.ubicacion.ubicaciones.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.ubicacion.ubicaciones.controller.UbicacionControllerV2;
import com.ubicacion.ubicaciones.model.Ubicacion;


@Component
public class UbicacionModelAssembler implements RepresentationModelAssembler<Ubicacion, EntityModel<Ubicacion>> {
    @Override
    public EntityModel<Ubicacion> toModel (Ubicacion ubicacion){
        return EntityModel.of(ubicacion,
            linkTo(methodOn(UbicacionControllerV2.class).buscar(ubicacion.getIdUbicacion())).withSelfRel(),
            linkTo(methodOn(UbicacionControllerV2.class).listar()).withRel("ubicaciones"));
    }

}
