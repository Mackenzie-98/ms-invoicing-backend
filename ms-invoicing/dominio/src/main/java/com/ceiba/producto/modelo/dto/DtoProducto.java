package com.ceiba.producto.modelo.dto;

import lombok.Getter;

@Getter
public class DtoProducto {
    private Long id;
    private String nombre;
    private Double precioUnitario;

    public DtoProducto(){}

    public DtoProducto(Long id, String nombre, Double precioUnitario) {
        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }
}
