package com.ceiba.detalle_factura.adaptador;

import com.ceiba.detalle_factura.modelo.entities.DetalleFactura;
import com.ceiba.detalle_factura.puerto.dao.IDaoDetalleFactura;
import com.ceiba.detalle_factura.puerto.repositorio.IRepositorioDetalleFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioDetalleFactura implements IDaoDetalleFactura {

    private IRepositorioDetalleFactura repositorio;

    @Override
    public DetalleFactura registrar(DetalleFactura detalleFactura) {
        return repositorio.save(detalleFactura);
    }

    @Override
    public Optional<DetalleFactura> buscarPorId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<DetalleFactura> listar() {
        return repositorio.listar();
    }
}
