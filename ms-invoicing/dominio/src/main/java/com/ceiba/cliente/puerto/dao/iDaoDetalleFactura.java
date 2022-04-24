package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.entities.DetalleFactura;

import java.util.List;
import java.util.Optional;

public interface iDaoDetalleFactura {

    DetalleFactura registrar(DetalleFactura DetalleFactura);

    Optional<DetalleFactura> buscarPorId(int id);

    void eliminar(int id);

    List<DetalleFactura> verDetalleFactura(int idFactura);

}
