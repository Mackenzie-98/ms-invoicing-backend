package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entities.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositorioFactura extends CrudRepository<Factura,Integer>{

    @Query(value = "select * from factura",nativeQuery = true)
    List<Factura> listar();
}