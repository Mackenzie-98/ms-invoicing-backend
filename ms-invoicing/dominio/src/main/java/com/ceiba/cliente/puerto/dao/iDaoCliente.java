package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import java.util.List;
import java.util.Optional;

public interface iDaoCliente {

    DtoCliente registrar(DtoCliente cliente);

    Optional<DtoCliente> buscarPorId(String identificacion);

    DtoCliente actualizar(DtoCliente nuevoCliente);

    void eliminar(String identificacion);

    List<DtoCliente> listar();

}
