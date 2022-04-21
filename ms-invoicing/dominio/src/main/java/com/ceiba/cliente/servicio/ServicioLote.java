package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entities.Lote;
import com.ceiba.cliente.puerto.dao.iDaoLote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioLote {

    public static final String LOTE_ELIMINADO = "El lote No. %s fue eliminado exitosamente.";
    public static final String LOTE_NO_ENCONTRADO = "Lote no encontrado.";
    @Autowired
    private iDaoLote daoLote;

    public ResponseEntity<Lote> registrarLote(Lote Lote){
        return new ResponseEntity(daoLote.registrar(Lote), HttpStatus.OK);
    }

    public ResponseEntity<Lote> buscarLotePorId(int id){
        Optional<Lote> busqueda = daoLote.buscarPorId(id);
        if(busqueda.isPresent())
            return new ResponseEntity(busqueda.get(),HttpStatus.OK);
        else
            return new ResponseEntity(LOTE_NO_ENCONTRADO,HttpStatus.NOT_FOUND);

    }
    public ResponseEntity<List<Lote>> listarLotes(){
        return new ResponseEntity(daoLote.listar(), HttpStatus.OK);
    }

    public ResponseEntity<String> eliminarLote(int id){
        daoLote.eliminar(id);
        return new ResponseEntity(String.format(LOTE_ELIMINADO, id), HttpStatus.OK);
    }
}
