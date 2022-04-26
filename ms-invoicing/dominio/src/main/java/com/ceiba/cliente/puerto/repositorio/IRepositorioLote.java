package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entities.Lote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositorioLote extends CrudRepository<Lote,Integer>{

    @Query(value = "select * from lote",nativeQuery = true)
    List<Lote> listar();
}
