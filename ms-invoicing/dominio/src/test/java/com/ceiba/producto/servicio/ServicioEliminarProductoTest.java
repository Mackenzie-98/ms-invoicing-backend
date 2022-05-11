package com.ceiba.producto.servicio;

import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarProductoTest {

    @Test
    @DisplayName("Deberia eliminar el producto llamando al repositorio")
    void deberiaEliminarElProductoLlamandoAlRepositorio() {
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        ServicioEliminarProducto servicioEliminarProducto = new ServicioEliminarProducto(repositorioProducto);

        servicioEliminarProducto.ejecutar(1l);

        Mockito.verify(repositorioProducto, Mockito.times(1)).eliminar(1l);

    }

}
