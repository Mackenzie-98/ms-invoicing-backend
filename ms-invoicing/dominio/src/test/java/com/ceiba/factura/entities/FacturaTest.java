package com.ceiba.factura.entities;

import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.factura.modelo.entities.Factura;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FacturaTest {

    @Test
    void deberiaCrearCorrectamenteUnaFactura() {
        //arrange
        LocalDate createAt = LocalDate.now();

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
                .detalleFacturas(null)
                .total(0)
                .build();

        //assert
        assertEquals(cliente,factura.getCliente());
        assertEquals(0,factura.getTotal());
        assertEquals(createAt,factura.getFecha());
        assertEquals("Factura de prueba",factura.getDescripcion());

    }

    @Test
    void deberiaCompararUnaFacturaCorrectamente() {
        LocalDate createAt = LocalDate.now();

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

        Factura facturaB = new Factura();
        facturaB.setId(1);
        facturaB.setCliente(cliente);
        facturaB.setDescripcion("Factura de prueba");
        facturaB.setFecha(createAt);
        facturaB.setDetalleFacturas(null);

        //assert
        assertTrue(facturaA.equals(facturaB));
        assertTrue(facturaA.hashCode() == facturaB.hashCode());

    }

}