package com.ceiba.detalle_factura.puerto.dao;

import com.ceiba.detalle_factura.modelo.entities.DetalleFactura;

import java.util.List;
import java.util.Optional;

public interface IDaoDetalleFactura {

    DetalleFactura registrar(DetalleFactura detalleFactura);

    Optional<DetalleFactura> buscarPorId(int id);

    void eliminar(int id);

    List<DetalleFactura> listar();

}
