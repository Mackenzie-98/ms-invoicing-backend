package com.ceiba.lote.puerto.dao;

import com.ceiba.lote.modelo.entities.Lote;

import java.util.List;
import java.util.Optional;

public interface IDaoLote {

    Lote registrar(Lote lote);

    Optional<Lote> buscarPorId(int id);

    void eliminar(int id);

    List<Lote> listar();

    int getCantidadProdcto(int idProducto);

}
