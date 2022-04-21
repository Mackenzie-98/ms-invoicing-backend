package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.entities.Lote;

import java.util.List;
import java.util.Optional;

public interface iDaoLote {

    Lote registrar(Lote Lote);

    Optional<Lote> buscarPorId(int id);

    void eliminar(int id);

    List<Lote> listar();

}
