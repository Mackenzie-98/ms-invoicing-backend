package com.ceiba.cliente.modelo.dto.response;

import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.cliente.modelo.entities.DetalleFactura;
import com.ceiba.cliente.modelo.entities.Factura;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoVerDetalleFactura {
    private Factura factura;
    private List<DetalleFactura> detalleCompras;
    private float total;
}
