package com.ceiba.detalle_factura.modelo.entities;

import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.factura.modelo.entities.Factura;
import com.ceiba.producto.modelo.entities.Producto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DetalleFacturaTest {
    @Test
    void deberiaCrearCorrectamenteUnDetalleFactura() {
        //arrange
        LocalDate createAt = LocalDate.now();

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