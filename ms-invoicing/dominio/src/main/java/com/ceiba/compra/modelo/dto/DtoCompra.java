package com.ceiba.compra.modelo.dto;

import com.ceiba.factura.modelo.entities.Factura;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DtoCompra {
    public Factura factura;
    public List<Integer> idProductos;
    public List<Integer> cantidades;
}
