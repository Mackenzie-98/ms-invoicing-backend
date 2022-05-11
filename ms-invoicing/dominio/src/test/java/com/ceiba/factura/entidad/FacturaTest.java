package com.ceiba.factura.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.servicio.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import com.ceiba.venta_producto.modelo.entidad.VentaProducto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacturaTest {

    @Test
    @DisplayName("Deberia crear correctamente la factura")
    void deberiaCrearCorrectamenteElUsFactura() {
        // arrange
        LocalDateTime fecha = LocalDateTime.now();
        Usuario usuario = new UsuarioTestDataBuilder().build();
        List<VentaProducto> productosVenta = Arrays.asList(new VentaProducto(1L,new Producto(1L,"Acetaminofen",1500.0),1),
                new VentaProducto(2L,new Producto(1L,"Acetaminofen",1500.0),1));
        //act
        Factura factura = new FacturaTestDataBuilder()
                .conId(1L)
                .conFecha(fecha)
                .conDescripcion("test")
                .conTotal(1500.0)
                .conUsuario(usuario)
                .conProductosVenta(productosVenta)
                .build();
        //assert
        assertEquals(1, factura.getId());
        assertEquals("test", factura.getDescripcion());
        assertEquals(1500.0, factura.getTotal());
        assertEquals(fecha, factura.getFecha());
        assertEquals(usuario, factura.getUsuario());
        assertEquals(productosVenta, factura.getProductosVenta());
    }

    @Test
    void deberiaFallarSinUsuarioDeFactura() {

        //Arrange
        FacturaTestDataBuilder FacturaTestDataBuilder = new FacturaTestDataBuilder().conUsuario(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    FacturaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar los datos del usuario.");
    }


    @Test
    void deberiaFallarSinFechaCreacion() {

        //Arrange
        FacturaTestDataBuilder facturaTestDataBuilder = new FacturaTestDataBuilder().conFecha(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                   facturaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación");
    }


}
