package com.ceiba.producto.servicio;

import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioEliminarProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioEliminarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Long id) {
        this.repositorioProducto.eliminar(id);
    }
}
