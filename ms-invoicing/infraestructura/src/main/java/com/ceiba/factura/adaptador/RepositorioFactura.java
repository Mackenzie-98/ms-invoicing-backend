package com.ceiba.factura.adaptador;

import com.ceiba.excepciones.ExcepcionTecnica;
import com.ceiba.factura.modelo.entities.Factura;
import com.ceiba.factura.puerto.dao.IDaoFactura;
import com.ceiba.factura.puerto.repositorio.IRepositorioFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.ceiba.excepciones.enums.EnumMensajeExcepcion.NO_ENCONTRADO;

@Repository
public class RepositorioFactura implements IDaoFactura {

    public static final String FACTURA_ELIMINADO_CON_EXITO = "Factura eliminada con exito.";
    private IRepositorioFactura repositorio;

    @Override
    public Factura registrar(Factura factura) {
        return repositorio.save(factura);
    }

    @Override
    public Optional<Factura> buscarPorId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public String eliminar(int id) {
        try{
            repositorio.deleteById(id);
            return FACTURA_ELIMINADO_CON_EXITO;
        }catch(Exception e){
            throw new ExcepcionTecnica(e,NO_ENCONTRADO);
        }
    }

    @Override
    public List<Factura> listar() {
        return repositorio.listar();
    }
}
