package com.ceiba.cliente.persistencia.repositorio;

import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.cliente.puerto.dao.iDaoCliente;
import com.ceiba.cliente.puerto.repositorio.iRepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioCliente implements iDaoCliente {

    @Autowired
    private iRepositorioCliente repositorioCliente;


    @Override
    public Cliente registrar(Cliente cliente) {
        return repositorioCliente.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarPorId(String identificacion) {
        return repositorioCliente.findById(identificacion);
    }

    @Override
    public void eliminar(String identificacion) {
        repositorioCliente.deleteById(identificacion);
    }

    @Override
    public List<Cliente> listar() {
        return repositorioCliente.listar();
    }
}
