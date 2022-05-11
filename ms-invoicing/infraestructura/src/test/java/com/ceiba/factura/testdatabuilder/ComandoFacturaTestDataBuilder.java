package com.ceiba.factura.testdatabuilder;

import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoUsuarioTestDataBuilder;
import com.ceiba.venta_producto.modelo.dto.DtoVentaProducto;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.time.LocalDateTime.now;

public class ComandoFacturaTestDataBuilder {

    private Long id;
    private LocalDateTime fecha;
    private String descripcion;
    private Double total;
    private DtoUsuario usuario;
    public List<DtoVentaProducto> productosVenta;

    public ComandoFacturaTestDataBuilder() {
        fecha = now();
        descripcion = UUID.randomUUID().toString();
        total = 1500.0;
        usuario = new DtoUsuario(1L,"test","1234",now());
        productosVenta = Arrays.asList(new DtoVentaProducto(1L,new DtoProducto(1L,"Acetaminofen",1500.0),1),
                new DtoVentaProducto(2L,new DtoProducto(1L,"Acetaminofen",1500.0),1));

    }

    public ComandoFactura build() {
        return new ComandoFactura(id, fecha,descripcion,usuario,productosVenta,total);
    }
}
