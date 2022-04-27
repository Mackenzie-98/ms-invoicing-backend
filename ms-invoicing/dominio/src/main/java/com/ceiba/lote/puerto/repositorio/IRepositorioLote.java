package com.ceiba.lote.puerto.repositorio;

import com.ceiba.lote.modelo.entities.Lote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRepositorioLote extends CrudRepository<Lote,Integer>{

    @Query(value = "select * from lote",nativeQuery = true)
    List<Lote> listar();

    @Query(value = "select count(*) from lote where id_producto =:idProducto")
    int getCantidadProducto(@Param("idProducto") int idProducto);
}
