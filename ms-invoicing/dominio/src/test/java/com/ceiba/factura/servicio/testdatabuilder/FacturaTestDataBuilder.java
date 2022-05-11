package com.ceiba.factura.servicio.testdatabuilder;

import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.venta_producto.modelo.entidad.VentaProducto;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.now;

public class FacturaTestDataBuilder {

    private Long id;
    private LocalDateTime fecha;
    private String descripcion;
    private Double total;
    private Usuario usuario;
    public List<VentaProducto> productosVenta;

    public FacturaTestDataBuilder() {
        fecha = now();
        descripcion = "test";
        total = 0.0;
        usuario = new Usuario(1L,"test","1234",now());
        productosVenta = Arrays.asList(new VentaProducto(1L,new Producto(1L,"Acetaminofen",1500.0),1),
                new VentaProducto(2L,new Producto(1L,"Acetaminofen",1500.0),1));
    }

    public FacturaTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public FacturaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public FacturaTestDataBuilder conFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public FacturaTestDataBuilder conTotal(Double total) {
        this.total = total;
        return this;
    }

    public FacturaTestDataBuilder conUsuario(Usuario usuario){
        this.usuario = usuario;
        return this;
    }

    public FacturaTestDataBuilder conProductosVenta(List<VentaProducto> productosVenta){
        this.productosVenta = productosVenta;
        return this;
    }

    public Factura build() {
        return new Factura(id,fecha,descripcion,total,usuario,productosVenta);
    }
}
