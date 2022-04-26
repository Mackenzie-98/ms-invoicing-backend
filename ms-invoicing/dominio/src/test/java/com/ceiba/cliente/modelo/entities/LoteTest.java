package com.ceiba.cliente.modelo.entities;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoteTest {
    @Test
    void deberiaCrearCorrectamenteUnLote() {
        // arrange - act
        Producto producto = Producto.builder()
                .nombre("productoTest")
                .precioUnitario(3450)
                .build();
        Date fechaVencimiento = new Date();
        Lote lote = Lote.builder()
                .id(1)
                .laboratorio("labTest")
                .fechaVencimiento(fechaVencimiento)
                .producto(producto)
                .cantidad(20)
                .build();

        //assert
        assertEquals("labTest", lote.getLaboratorio());
        assertEquals(fechaVencimiento, lote.getFechaVencimiento());
        assertEquals(producto, lote.getProducto());
        assertEquals(20,lote.getCantidad());
    }
}