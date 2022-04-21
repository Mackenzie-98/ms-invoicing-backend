package com.ceiba.Factura.servicio;

import com.ceiba.cliente.modelo.entities.Factura;
import com.ceiba.cliente.puerto.dao.iDaoFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioFactura {

    public static final String FACTURA_ELIMINADA = "La factura No. %s fue eliminada exitosamente.";
    public static final String FACTURA_NO_ENCONTRADA = "Factura no encontrada.";
    @Autowired
    private iDaoFactura daoFactura;

    public ResponseEntity<Factura> registrarFactura(Factura Factura){
        return new ResponseEntity(daoFactura.registrar(Factura), HttpStatus.OK);
    }

    public ResponseEntity<Factura> buscarFacturaPorId(int id){
        Optional<Factura> busqueda = daoFactura.buscarPorId(id);
        if(busqueda.isPresent())
            return new ResponseEntity(busqueda.get(),HttpStatus.OK);
        else
            return new ResponseEntity(FACTURA_NO_ENCONTRADA,HttpStatus.NOT_FOUND);

    }
    public ResponseEntity<List<Factura>> listarFacturas(){
        return new ResponseEntity(daoFactura.listar(), HttpStatus.OK);
    }

    public ResponseEntity<String> eliminarFactura(int id){
        daoFactura.eliminar(id);
        return new ResponseEntity(String.format(FACTURA_ELIMINADA, id), HttpStatus.OK);
    }
}
