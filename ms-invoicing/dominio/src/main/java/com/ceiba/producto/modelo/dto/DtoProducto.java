package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DtoProducto {
    private Long id;
    private String nombre;
    private Double precioUnitario;

}