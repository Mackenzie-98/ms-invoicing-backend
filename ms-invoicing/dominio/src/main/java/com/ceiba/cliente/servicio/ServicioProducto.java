package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entities.Producto;
import com.ceiba.cliente.puerto.dao.iDaoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioProducto {

    public static final String PRODUCTO_ELIMINADO = "El producto No. %s fue eliminado exitosamente.";
    public static final String PRODUCTO_NO_ENCONTRADO = "Producto no encontrado.";
    @Autowired
    private iDaoProducto daoProducto;

    public ResponseEntity<Producto> registrarProducto(Producto Producto){
        return new ResponseEntity(daoProducto.registrar(Producto), HttpStatus.OK);
    }

    public ResponseEntity<Producto> buscarProductoPorId(int id){
        Optional<Producto> busqueda = daoProducto.buscarPorId(id);
        if(busqueda.isPresent())
            return new ResponseEntity(busqueda.get(),HttpStatus.OK);
        else
            return new ResponseEntity(PRODUCTO_NO_ENCONTRADO,HttpStatus.NOT_FOUND);

    }
    public ResponseEntity<List<Producto>> listarProductos(){
        return new ResponseEntity(daoProducto.listar(), HttpStatus.OK);
    }

    public ResponseEntity<String> eliminarProducto(int id){
        daoProducto.eliminar(id);
        return new ResponseEntity(String.format(PRODUCTO_ELIMINADO, id), HttpStatus.OK);
    }
}
