package com.ceiba.factura.modelo.entidad;


import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.venta_producto.modelo.entidad.VentaProducto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Factura {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_LOS_DATOS_DEL_USUARIO = "Se debe ingresar los datos del usuario.";

    private Long id;
    private LocalDateTime fecha;
    private String descripcion;
    private Double total;

    private Usuario usuario;
    private List<VentaProducto> productosVenta;

    public Factura(Long id, LocalDateTime fecha, String descripcion, Double total, Usuario usuario,List<VentaProducto> productosVenta) {
        validarObligatorio(usuario,SE_DEBE_INGRESAR_LOS_DATOS_DEL_USUARIO);
        validarObligatorio(fecha,SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.total = total;
        this.usuario = usuario;
        this.productosVenta = productosVenta;
    }
}
