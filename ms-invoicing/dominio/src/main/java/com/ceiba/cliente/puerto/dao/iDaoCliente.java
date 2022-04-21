package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface iDaoCliente {

    Cliente registrar(Cliente cliente);

    Optional<Cliente> buscarPorId(String identificacion);

    void eliminar(String identificacion);

    List<Cliente> listar();

}
