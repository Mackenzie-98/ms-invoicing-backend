package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.dto.request.DtoCompra;
import com.ceiba.cliente.modelo.entities.DetalleFactura;
import com.ceiba.cliente.modelo.entities.Factura;
import com.ceiba.cliente.modelo.entities.Producto;
import com.ceiba.cliente.modelo.excepciones.ExcepcionTecnica;
import com.ceiba.cliente.modelo.excepciones.enums.EnumMensajeExcepcion;
import com.ceiba.cliente.puerto.dao.IDaoFactura;
import com.ceiba.cliente.puerto.dao.IDaoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ceiba.cliente.modelo.excepciones.enums.EnumMensajeExcepcion.COMPRA_EXCEPCION;

@Service
public class ServicioCompra {

    @Autowired
    private IDaoProducto daoProducto;

    @Autowired
    private IDaoFactura daoFactura;


    public ResponseEntity<Factura> crearCompra(DtoCompra compra){
        try{
            int cantidadProductos = compra.getIdProductos().size();
            Factura factura = compra.getFactura();
            List<DetalleFactura> listaCompra = new ArrayList<>();
            for(int i =0; i < cantidadProductos; i++){

                Optional<Producto> producto = daoProducto.buscarPorId(compra.getIdProductos().get(i));

                DetalleFactura detalleFactura = DetalleFactura.builder()
                        .producto(producto.get())
                        .factura(compra.getFactura())
                        .cantidad(compra.getCantidad().get(i))
                        .build();
                        listaCompra.add(detalleFactura);
            }
            factura.setDetalleFacturas(listaCompra);

            return new ResponseEntity(daoFactura.registrar(factura), HttpStatus.OK);
        }catch (Exception e){
            throw new ExcepcionTecnica(e, COMPRA_EXCEPCION);
        }
    }
}
