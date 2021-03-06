package com.ceiba.factura.comando;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.venta_producto.modelo.dto.DtoVentaProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoFactura {
    private Long id;
    private LocalDateTime fecha;
    private String descripcion;
    private DtoUsuario usuario;
    private List<DtoVentaProducto> productosVenta;
    private Double total;
}
