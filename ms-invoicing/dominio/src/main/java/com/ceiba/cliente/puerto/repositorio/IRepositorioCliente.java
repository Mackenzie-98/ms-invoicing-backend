package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface IRepositorioCliente extends CrudRepository<Cliente,String>{

    @Query(value = "select * from cliente",nativeQuery = true)
    List<Cliente> listar();
}
