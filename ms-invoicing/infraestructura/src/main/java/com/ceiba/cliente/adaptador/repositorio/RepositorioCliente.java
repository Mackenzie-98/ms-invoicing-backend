package com.ceiba.cliente.adaptador.repositorio;

import com.ceiba.cliente.modelo.dto.DtoCliente;
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
    public DtoCliente registrar(DtoCliente cliente) {
        return repositorioCliente.save(cliente);
    }

    @Override
    public Optional<DtoCliente> buscarPorId(String identificacion) {
        return repositorioCliente.findById(identificacion);
    }

    @Override
    public DtoCliente actualizar(DtoCliente nuevoCliente) {
        if(repositorioCliente.existsById(nuevoCliente.getIdentificacion())){
            repositorioCliente.deleteById(nuevoCliente.getIdentificacion());
        }
        return repositorioCliente.save(nuevoCliente);
    }

    @Override
    public void eliminar(String identificacion) {
        repositorioCliente.deleteById(identificacion);
    }

    @Override
    public List<DtoCliente> listar() {
        return repositorioCliente.listar();
    }
}
