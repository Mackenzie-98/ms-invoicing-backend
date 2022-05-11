package com.ceiba.venta_producto.puerto.dao;

import com.ceiba.venta_producto.modelo.dto.DtoVentaProducto;

import java.util.List;

public interface DaoVentaProducto {

    /**
     * Permite listar una venta de producto
     * @return una venta de producto
     */
    List<DtoVentaProducto> listar();

    List<DtoVentaProducto> listarPorId(Long idFactura);
}
