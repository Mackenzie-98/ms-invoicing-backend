package com.ceiba.factura.puerto.dao;

import com.ceiba.factura.modelo.entities.Factura;

import java.util.List;
import java.util.Optional;

public interface IDaoFactura {

    Factura registrar(Factura factura);

    Optional<Factura> buscarPorId(int id);

    String eliminar(int id);

    List<Factura> listar();

}
