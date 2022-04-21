package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface iRepositorioCliente extends CrudRepository<DtoCliente,String>{

    @Query(value = "select * from cliente",nativeQuery = true)
    List<DtoCliente> listar();
}
