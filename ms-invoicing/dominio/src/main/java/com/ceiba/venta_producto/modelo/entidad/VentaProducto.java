package com.ceiba.venta_producto.modelo.entidad;


import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.producto.modelo.entidad.Producto;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class VentaProducto {

    private static final String SE_DEBE_INGRESAR_EL_PRODUTO = "Se debe ingresar el producto";
    private static final String SE_DEBE_INGRESAR_LA_FACTURA = "Se debe ingresar la factura";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD = "Se debe ingresar la cantidad de producto que desea adquirir.";

    private Long id;
    private Producto producto;
    private Integer cantidad;

    public VentaProducto(Long id, Producto producto, Integer cantidad) {
        validarObligatorio(producto,SE_DEBE_INGRESAR_EL_PRODUTO);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_LA_CANTIDAD);
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
    }

}
