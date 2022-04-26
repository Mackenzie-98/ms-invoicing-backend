package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entities.DetalleFactura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRepositorioDetalleFactura extends CrudRepository<DetalleFactura,Integer>{

    @Query(value = "select * from detalle_factura where id_factura = :idFactura",nativeQuery = true)
    List<DetalleFactura> verDetalleFactura(@Param("idFactura") int idFactura);
}
