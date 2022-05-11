package com.ceiba.producto.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductoTest {

    @Autowired
    Logger log= Logger.getGlobal();
    @Test
    @DisplayName("Deberia crear correctamente el producto")
    void deberiaCrearCorrectamenteElProducto() {
        // arrange-act
        Producto producto = new ProductoTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, producto.getId());
        assertEquals("test", producto.getNombre());
        assertEquals(1500.0,producto.getPrecioUnitario());
    }

    @Test
    void deberiaFallarSinNombreDeProducto() {

        //Arrange
        ProductoTestDataBuilder ProductoTestDataBuilder = new ProductoTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    ProductoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de producto");
    }

    @Test
    void deberiaFallarSinPrecioUnitario() {

        //Arrange
        ProductoTestDataBuilder ProductoTestDataBuilder = new ProductoTestDataBuilder().conPrecioUnitario(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    ProductoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el precio unitario");
    }



}
