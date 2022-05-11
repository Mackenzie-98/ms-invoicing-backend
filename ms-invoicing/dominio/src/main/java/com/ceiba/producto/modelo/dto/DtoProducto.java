package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoProducto {
    private Long id;
    private String nombre;
    private Double precioUnitario;

}
