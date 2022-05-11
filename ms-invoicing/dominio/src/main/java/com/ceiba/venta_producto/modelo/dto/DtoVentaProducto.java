package com.ceiba.venta_producto.modelo.dto;

import com.ceiba.producto.modelo.dto.DtoProducto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoVentaProducto {
    private Long id;
    private DtoProducto producto;
    private Integer cantidad;
}
