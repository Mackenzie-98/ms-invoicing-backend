package com.ceiba.cliente.modelo.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DetalleFacturaTest {
    @Test
    void deberiaCrearCorrectamenteUnDetalleFactura() {
        //arrange
        Date createAt = new Date();

        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("Edinsson")
                .apellido("Melo")
                .build();

        Factura facturaTest = Factura.builder()
                .cliente(cliente)
                .descripcion("Factura de prueba")
                .fecha(createAt)
                .build();

        Producto productoTest = Producto.builder()
                .nombre("testName")
                .precioUnitario(1500)
                .build();
        //act
        DetalleFactura detalleFactura = DetalleFactura.builder()
                .id(1)
                .factura(facturaTest)
                .producto(productoTest)
                .cantidad(30)
                .build();

        //assert
        assertEquals(facturaTest,detalleFactura.getFactura());
        assertEquals(productoTest,detalleFactura.getProducto());
        assertEquals(30,detalleFactura.getCantidad());

    }
}