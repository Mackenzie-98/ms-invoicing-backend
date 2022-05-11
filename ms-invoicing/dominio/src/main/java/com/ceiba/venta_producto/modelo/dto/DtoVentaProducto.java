package com.ceiba.venta_producto.modelo.dto;

import com.ceiba.producto.modelo.dto.DtoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class DtoVentaProducto {
    private Long id;
    private DtoProducto producto;
    private Integer cantidad;
}
