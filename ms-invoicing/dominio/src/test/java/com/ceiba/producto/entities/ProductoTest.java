package com.ceiba.producto.entities;

import com.ceiba.producto.modelo.entities.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductoTest {

    @Test
    void deberiaCrearCorrectamenteUnProducto() {
        // arrange - act
        Producto producto= Producto.builder()
                .nombre("testName")
                .precioUnitario(1500)
                .lotes(null)
                .detalleFacturas(null)
                .build();

        //assert
        assertEquals(0, producto.getId());
        assertEquals("testName", producto.getNombre());
        assertEquals(1500, producto.getPrecioUnitario());
        assertEquals(null, producto.getLotes());
        assertEquals(null, producto.getDetalleFacturas());
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
                .id(1)
                .nombre("testName")
                .precioUnitario(1500)
                .build();

        //asserts
        assertTrue(productoA.equals(productoB) && productoB.equals(productoA));
        assertTrue(productoA.hashCode() == productoB.hashCode());
    }
}