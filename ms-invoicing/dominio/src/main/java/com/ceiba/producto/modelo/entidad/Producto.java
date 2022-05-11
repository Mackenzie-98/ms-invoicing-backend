package com.ceiba.producto.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Producto {

    private static final String SE_DEBE_INGRESAR_EL_PRECIO_UNITARIO = "Se debe ingresar el precio unitario";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_PRODUCTO = "Se debe ingresar el nombre de producto";
    private Long id;
    private String nombre;
    private Double precioUnitario;

    public Producto(Long id, String nombre, Double precioUnitario) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_PRODUCTO);
        validarObligatorio(precioUnitario, SE_DEBE_INGRESAR_EL_PRECIO_UNITARIO);

        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

}
