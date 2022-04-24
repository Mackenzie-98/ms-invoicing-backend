package com.ceiba.compra.controlador;

import com.ceiba.cliente.modelo.dto.request.DtoCompra;
import com.ceiba.cliente.modelo.entities.Factura;
import com.ceiba.cliente.servicio.ServicioCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
@Api(tags = { "Controlador detalleFactura"})
public class ControladorCompra {

    @Autowired
    private ServicioCompra servicioCompra;

    @PostMapping("/crear")
    @ApiOperation("Facturar una compra")
    public ResponseEntity<Factura> crear(@RequestBody DtoCompra compra){
        return servicioCompra.crearCompra(compra);
    }

}
