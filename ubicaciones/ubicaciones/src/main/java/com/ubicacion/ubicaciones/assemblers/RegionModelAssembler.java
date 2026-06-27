package com.ubicacion.ubicaciones.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.ubicacion.ubicaciones.controller.RegionControllerV2;
import com.ubicacion.ubicaciones.model.Region;



@Component
public class RegionModelAssembler implements RepresentationModelAssembler<Region, EntityModel<Region>> {
    @Override
    public EntityModel<Region> toModel (Region region){
        return EntityModel.of(region,
            linkTo(methodOn(RegionControllerV2.class).buscar(region.getIdRegion())).withSelfRel(),
            linkTo(methodOn(RegionControllerV2.class).listar()).withRel("regiones"));
    }

}
