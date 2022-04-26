package com.ceiba.cliente.modelo.entities;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FacturaTest {

    @Test
    void deberiaCrearCorrectamenteUnaFactura() {
        //arrange
        Date createAt = new Date();

        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("Edinsson")
                .apellido("Melo")
                .build();

        //act
        Factura factura = Factura.builder()
                .id(1)
                .cliente(cliente)
                .descripcion("Factura de prueba")
                .fecha(createAt)
                .build();

        //assert
        assertEquals(cliente,factura.getCliente());
        assertEquals("Factura de prueba",factura.getDescripcion());
        assertEquals(createAt,factura.getFecha());

    }

    @Test
    void deberiaCompararUnaFacturaCorrectamente() {
        Date createAt = new Date();

        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("Edinsson")
                .apellido("Melo")
                .build();

        //act
        Factura facturaA = new Factura();
        facturaA.setId(1);
        facturaA.setCliente(cliente);
        facturaA.setDescripcion("Factura de prueba");
        facturaA.setFecha(createAt);
        facturaA.setDetalleFacturas(null);

        Factura facturaB = Factura.builder()
                .id(2)
                .cliente(cliente)
                .descripcion("Factura de prueba")
                .fecha(createAt)
                .build();
        //assert
        assertEquals(true,facturaA.equals(facturaA));
        assertEquals(false,facturaA.equals(facturaB));

    }
}