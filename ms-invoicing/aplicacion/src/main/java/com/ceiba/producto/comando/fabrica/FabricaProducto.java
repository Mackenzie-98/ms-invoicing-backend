package com.ceiba.producto.comando.fabrica;

import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

import static java.time.LocalDateTime.now;

@Component
public class FabricaProducto {

    public Producto crear(ComandoProducto comandoProducto) {
        return new Producto(
                comandoProducto.getId(),
                comandoProducto.getNombre(),
                comandoProducto.getPrecioUnitario()
        );
    }

}
