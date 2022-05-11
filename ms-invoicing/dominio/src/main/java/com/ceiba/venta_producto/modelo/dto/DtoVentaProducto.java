package com.ceiba.venta_producto.modelo.dto;

import com.ceiba.producto.modelo.dto.DtoProducto;
import lombok.Getter;

@Getter
public class DtoVentaProducto {
    private Long id;
    private DtoProducto producto;
    private Integer cantidad;

    public DtoVentaProducto(){}
    public DtoVentaProducto(Long id, DtoProducto producto, Integer cantidad) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
