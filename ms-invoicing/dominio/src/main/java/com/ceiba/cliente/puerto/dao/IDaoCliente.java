package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.entities.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface IDaoCliente {

    Cliente registrar(Cliente cliente);

    Optional<Cliente> buscarPorId(String identificacion);

    String eliminar(String identificacion);

    List<Cliente> listar();

}
