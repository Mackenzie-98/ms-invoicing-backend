package com.ceiba.factura.servicio;

import com.ceiba.excepciones.ExcepcionTecnica;
import com.ceiba.factura.modelo.entities.Factura;
import com.ceiba.factura.puerto.dao.IDaoFactura;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ceiba.excepciones.enums.EnumMensajeExcepcion.NO_ENCONTRADO;

@Service
public class ServicioFactura {

    public static final String FACTURA_ELIMINADA = "Factura eliminada con exito.";
    private final IDaoFactura daoFactura;

    public ServicioFactura(IDaoFactura daoFactura) {
        this.daoFactura = daoFactura;
    }

    public ResponseEntity<Factura> registrarFactura(Factura Factura){
        return new ResponseEntity(daoFactura.registrar(Factura), HttpStatus.OK);
    }

    public ResponseEntity<Factura> buscarFacturaPorId(int id){
        Optional<Factura> busqueda = daoFactura.buscarPorId(id);
        if(busqueda.isPresent())
            return new ResponseEntity(busqueda.get(),HttpStatus.OK);
        else
            throw new ExcepcionTecnica(NO_ENCONTRADO);

    }
    public ResponseEntity<List<Factura>> listarFacturas(){
        return new ResponseEntity(daoFactura.listar(), HttpStatus.OK);
    }

    public ResponseEntity<String> eliminarFactura(int id){
        return new ResponseEntity(daoFactura.eliminar(id), HttpStatus.OK);
    }
}