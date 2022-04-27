package com.ceiba.producto.adaptador;

import com.ceiba.producto.modelo.entities.Producto;
import com.ceiba.producto.puerto.dao.IDaoProducto;
import com.ceiba.producto.puerto.repositorio.IRepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioProducto implements IDaoProducto {

    private IRepositorioProducto repositorio;

    @Override
    public Producto registrar(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public Optional<Producto> buscarPorId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Producto> listar() {
        return repositorio.listar();
    }
}
