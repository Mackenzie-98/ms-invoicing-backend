package com.ceiba.lote.persistencia.repositorio;

import com.ceiba.cliente.modelo.entities.Lote;
import com.ceiba.cliente.puerto.dao.iDaoLote;
import com.ceiba.cliente.puerto.repositorio.iRepositorioLote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioLote implements iDaoLote {

    @Autowired
    private iRepositorioLote repositorioLote;


    @Override
    public Lote registrar(Lote Lote) {
        return repositorioLote.save(Lote);
    }

    @Override
    public Optional<Lote> buscarPorId(int id) {
        return repositorioLote.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorioLote.deleteById(id);
    }

    @Override
    public List<Lote> listar() {
        return repositorioLote.listar();
    }
}
