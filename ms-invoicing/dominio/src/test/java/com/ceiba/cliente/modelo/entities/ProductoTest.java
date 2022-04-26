package com.ceiba.cliente.modelo.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductoTest {

    @Test
    void deberiaCrearCorrectamenteUnProducto() {
        // arrange - act
        Producto producto= Producto.builder()
                .nombre("testName")
                .precioUnitario(1500)
                .build();

        //assert
        assertEquals("testName", producto.getNombre());
        assertEquals(1500, producto.getPrecioUnitario());
    }
    @Test
    void deberiaCompararCorrectamenteUnProducto() {
        // arrange - act
        Producto productoA= Producto.builder()
                .id(1)
                .nombre("testName")
                .precioUnitario(1500)
                .build();
        Producto productoB= Producto.builder()
                .id(2)
                .nombre("testName")
                .precioUnitario(1500)
                .build();

        //asserts
        assertEquals(true, productoA.equals(productoA));
        assertEquals(false,productoA.equals(productoB));
    }
}