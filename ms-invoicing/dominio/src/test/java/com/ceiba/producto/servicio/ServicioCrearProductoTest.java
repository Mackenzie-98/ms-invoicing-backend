package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearProductoTest {


    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del producto")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelProducto() {
        // arrange
        Producto Producto = new ProductoTestDataBuilder().build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearProducto.ejecutar(Producto), ExcepcionDuplicidad.class,"El producto ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia crear el producto de manera correcta")
    void deberiaCrearElProductoDeManeraCorrecta() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conId(10L).build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioProducto.crear(producto)).thenReturn(10L);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        // act
        Long idProducto = servicioCrearProducto.ejecutar(producto);
        //- assert
        assertEquals(10L,idProducto);
        Mockito.verify(repositorioProducto, Mockito.times(1)).crear(producto);
    }
}
