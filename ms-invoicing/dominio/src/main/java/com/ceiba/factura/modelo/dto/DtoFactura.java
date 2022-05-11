package com.ceiba.factura.modelo.dto;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.venta_producto.modelo.dto.DtoVentaProducto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class DtoFactura {
    private Long id;
    private LocalDateTime fecha;
    private String descripcion;
    private DtoUsuario usuario;
    private List<DtoVentaProducto> productosVenta;
    private Double total;

    public DtoFactura(){}

    public DtoFactura(Long id, LocalDateTime fecha, String descripcion, DtoUsuario usuario, List<DtoVentaProducto> productosVenta, Double total) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.productosVenta = productosVenta;
        this.total = total;
    }
}
