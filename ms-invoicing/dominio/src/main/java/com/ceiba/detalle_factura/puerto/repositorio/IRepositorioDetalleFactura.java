package com.ceiba.detalle_factura.puerto.repositorio;

import com.ceiba.detalle_factura.modelo.entities.DetalleFactura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRepositorioDetalleFactura extends CrudRepository<DetalleFactura,Integer>{

    @Query(value = "select * from detalle_factura",nativeQuery = true)
    List<DetalleFactura> listar();
}
