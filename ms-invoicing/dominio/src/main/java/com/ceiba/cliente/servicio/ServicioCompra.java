package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.dto.request.DtoCompra;
import com.ceiba.cliente.modelo.entities.DetalleFactura;
import com.ceiba.cliente.modelo.entities.Factura;
import com.ceiba.cliente.modelo.entities.Producto;
import com.ceiba.cliente.puerto.dao.iDaoFactura;
import com.ceiba.cliente.puerto.dao.iDaoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioCompra {

    @Autowired
    private iDaoProducto daoProducto;

    @Autowired
    private iDaoFactura daoFactura;


    public ResponseEntity<Factura> crearCompra(DtoCompra compra){
        int cantidadProductos = compra.getIdProductos().size();
        Factura factura = compra.getFactura();
        List<DetalleFactura> listaCompra = new ArrayList<>();
        for(int i =0; i < cantidadProductos; i++){

            Optional<Producto> producto = daoProducto.buscarPorId(compra.getIdProductos().get(i));

            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFactura.setProducto(producto.get());
            detalleFactura.setFactura(compra.getFactura());
            detalleFactura.setCantidad(compra.getCantidad().get(i));
            listaCompra.add(detalleFactura);
        }
        factura.setDetalleFacturas(listaCompra);

        return new ResponseEntity(daoFactura.registrar(factura), HttpStatus.OK);
    }
}
