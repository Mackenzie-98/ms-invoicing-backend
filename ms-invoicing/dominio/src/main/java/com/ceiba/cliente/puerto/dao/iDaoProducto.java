package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface iDaoProducto {

    Producto registrar(Producto Producto);

    Optional<Producto> buscarPorId(int id);

    void eliminar(int id);

    List<Producto> listar();

}
