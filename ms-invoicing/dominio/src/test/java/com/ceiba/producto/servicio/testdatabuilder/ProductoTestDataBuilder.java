package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class ProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private Double precioUnitario;
    public ProductoTestDataBuilder() {
        nombre ="test";
        precioUnitario = 1500.0;
    }

    public ProductoTestDataBuilder conPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
        return this;
    }

    public ProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Producto build() {
        return new Producto(id,nombre, precioUnitario);
    }
}
