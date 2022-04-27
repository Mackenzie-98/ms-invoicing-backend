package com.ceiba.cliente.fabrica;

import com.ceiba.cliente.ComandoCliente;
import com.ceiba.cliente.modelo.entities.Cliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {

    public Cliente crear(ComandoCliente comandoCliente) {
        return Cliente.builder()
                .identificacion(comandoCliente.getIdentificacion())
                .nombre(comandoCliente.getNombre())
                .apellido(comandoCliente.getApellido())
                .build();
    }

}