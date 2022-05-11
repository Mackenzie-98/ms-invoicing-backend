package com.ceiba.factura.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.venta_producto.puerto.repositorio.RepositorioVentaProducto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearFacturaTest {


    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de la factura")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelFactura() {
        // arrange
        Factura factura = new FacturaTestDataBuilder().conId(10L).build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        RepositorioVentaProducto repositorioVentaProducto = Mockito.mock(RepositorioVentaProducto.class);
        Mockito.when(repositorioFactura.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura,repositorioVentaProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearFactura.ejecutar(factura), ExcepcionDuplicidad.class,"La factura ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el Factura de manera correcta")
    void deberiaCrearLaFacturaDeManeraCorrecta() {
        // arrange
        Factura factura = new FacturaTestDataBuilder().build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        RepositorioVentaProducto repositorioVentaProducto = Mockito.mock(RepositorioVentaProducto.class);
        Mockito.when(repositorioFactura.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioFactura.crear(factura)).thenReturn(10L);
        ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura,repositorioVentaProducto);
        // act
        Long idFactura = servicioCrearFactura.ejecutar(factura);
        //- assert
        assertEquals(10L,idFactura);
        Mockito.verify(repositorioFactura, Mockito.times(1)).crear(factura);
    }
}
