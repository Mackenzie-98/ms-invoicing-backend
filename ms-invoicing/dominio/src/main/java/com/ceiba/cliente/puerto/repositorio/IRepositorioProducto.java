package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositorioProducto extends CrudRepository<Producto,Integer>{

    @Query(value = "select * from producto",nativeQuery = true)
    List<Producto> listar();
}
