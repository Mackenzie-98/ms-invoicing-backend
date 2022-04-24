package com.ceiba.cliente.modelo.dto.request;

import com.ceiba.cliente.modelo.entities.Factura;
import lombok.Data;

import java.util.List;

@Data
public class DtoCompra {
    private Factura factura;
    private List<Integer> idProductos;
    private List<Integer> cantidad;
}
