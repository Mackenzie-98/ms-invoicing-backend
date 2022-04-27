package com.ceiba.lote.adaptador;

import com.ceiba.lote.modelo.entities.Lote;
import com.ceiba.lote.puerto.dao.IDaoLote;
import com.ceiba.lote.puerto.repositorio.IRepositorioLote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioLote implements IDaoLote {

    private IRepositorioLote repositorio;

    public Lote registrar(Lote lote) {
        return repositorio.save(lote);
    }

    @Override
    public Optional<Lote> buscarPorId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Lote> listar() {
        return repositorio.listar();
    }

    @Override
    public int getCantidadProdcto(int idProducto) {
        return repositorio.getCantidadProducto(idProducto);
    }

}
