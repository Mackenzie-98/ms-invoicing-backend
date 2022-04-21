package com.ceiba.factura.persistencia.repositorio;

import com.ceiba.cliente.modelo.entities.Factura;
import com.ceiba.cliente.puerto.dao.iDaoFactura;
import com.ceiba.cliente.puerto.repositorio.iRepositorioFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioFactura implements iDaoFactura {

    @Autowired
    private iRepositorioFactura repositorioFactura;


    @Override
    public Factura registrar(Factura factura) {
        return repositorioFactura.save(factura);
    }

    @Override
    public Optional<Factura> buscarPorId(int id) {
        return repositorioFactura.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorioFactura.deleteById(id);
    }

    @Override
    public List<Factura> listar() {
        return repositorioFactura.listar();
    }
}
