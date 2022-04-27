package com.ceiba.producto.puerto.dao;

import com.ceiba.producto.modelo.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface IDaoProducto {

    Producto registrar(Producto producto);

    Optional<Producto> buscarPorId(int id);

    void eliminar(int id);

    List<Producto> listar();

}
