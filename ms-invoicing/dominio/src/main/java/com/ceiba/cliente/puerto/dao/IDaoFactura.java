package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.entities.Factura;

import java.util.List;
import java.util.Optional;

public interface IDaoFactura {

    Factura registrar(Factura factura);

    Optional<Factura> buscarPorId(int id);

    void eliminar(int id);

    List<Factura> listar();

}
