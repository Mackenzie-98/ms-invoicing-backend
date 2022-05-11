package com.ceiba.producto.testdatabuilder;

import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private Double precioUnitario;
    public ComandoProductoTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        precioUnitario = 1500.0;
    }

    public ComandoProducto build() {
        return new ComandoProducto(id,nombre, precioUnitario);
    }
}
