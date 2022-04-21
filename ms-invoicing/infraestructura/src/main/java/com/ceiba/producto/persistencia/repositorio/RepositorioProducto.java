package com.ceiba.producto.persistencia.repositorio;

import com.ceiba.cliente.modelo.entities.Producto;
import com.ceiba.cliente.puerto.dao.iDaoProducto;
import com.ceiba.cliente.puerto.repositorio.iRepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioProducto implements iDaoProducto {

    @Autowired
    private iRepositorioProducto repositorioProducto;


    @Override
    public Producto registrar(Producto Producto) {
        return repositorioProducto.save(Producto);
    }

    @Override
    public Optional<Producto> buscarPorId(int id) {
        return repositorioProducto.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorioProducto.deleteById(id);
    }

    @Override
    public List<Producto> listar() {
        return repositorioProducto.listar();
    }
}