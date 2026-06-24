package com.cliente.clientes.assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.cliente.clientes.controller.ClienteControllerV2;
import com.cliente.clientes.model.Cliente;

@Component
public class ClienteModelAssembler {
    @Override
    public EntityModel<Cliente> toModel (Cliente cliente){
        EntityModel.of(cliente,
            linkTo(methodOn(ClienteControllerV2.class).getClienteByRut(cliente.getRut())).withSelfRel(),
            linkTo(methodOn(ClienteControllerV2.class).getAllClientes()).withRel("clientes"));
    }
}
