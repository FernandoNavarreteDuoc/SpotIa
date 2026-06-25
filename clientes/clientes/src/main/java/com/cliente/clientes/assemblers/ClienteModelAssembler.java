package com.cliente.clientes.assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.cliente.clientes.controller.ClienteControllerV2;
import com.cliente.clientes.model.Cliente;

@Component
public class ClienteModelAssembler implements RepresentationModelAssembler<Cliente, EntityModel<Cliente>>{
    @Override
    public EntityModel<Cliente> toModel (Cliente cliente){
        return EntityModel.of(cliente,
            linkTo(methodOn(ClienteControllerV2.class).getClienteByRut(cliente.getRut())).withSelfRel(),
            linkTo(methodOn(ClienteControllerV2.class).getAllClientes()).withRel("clientes"));
    }
}
