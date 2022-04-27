package com.ceiba.producto.puerto.repositorio;

import com.ceiba.producto.modelo.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRepositorioProducto extends CrudRepository<Producto,Integer>{

    @Query(value = "select * from producto",nativeQuery = true)
    List<Producto> listar();
}
