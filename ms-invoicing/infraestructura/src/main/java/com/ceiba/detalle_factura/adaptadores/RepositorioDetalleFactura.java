package com.ceiba.detalle_factura.adaptadores;

import com.ceiba.cliente.modelo.entities.DetalleFactura;
import com.ceiba.cliente.puerto.dao.iDaoDetalleFactura;
import com.ceiba.cliente.puerto.repositorio.iRepositorioDetalleFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioDetalleFactura implements iDaoDetalleFactura {

    @Autowired
    private iRepositorioDetalleFactura repositorioDetalleFactura;


    @Override
    public DetalleFactura registrar(DetalleFactura DetalleFactura) {
        return repositorioDetalleFactura.save(DetalleFactura);
    }

    @Override
    public Optional<DetalleFactura> buscarPorId(int id) {
        return repositorioDetalleFactura.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorioDetalleFactura.deleteById(id);
    }

    @Override
    public List<DetalleFactura> verDetalleFactura(int idFactura) {
        return repositorioDetalleFactura.verDetalleFactura(idFactura);
    }
}
