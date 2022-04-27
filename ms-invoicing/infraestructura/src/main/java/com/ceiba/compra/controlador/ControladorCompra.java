package com.ceiba.compra.controlador;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.servicio.ServicioCompra;
import com.ceiba.factura.modelo.entities.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class ControladorCompra {

    @Autowired
    private ServicioCompra servicioCompra;

    @PostMapping("/crear")
    public ResponseEntity<Factura> crear(@RequestBody DtoCompra compra){
        return servicioCompra.crearCompra(compra);
    }

}
