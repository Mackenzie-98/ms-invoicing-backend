package com.ceiba.detalle_factura.controlador;

import com.ceiba.cliente.modelo.dto.response.DtoVerDetalleFactura;
import com.ceiba.cliente.servicio.ServicioDetalleFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalle-factura")
public class ControladorDetalleFactura {

    @Autowired
    private ServicioDetalleFactura servicioDetalleFactura;

    @GetMapping("/ver/factura/{id}")
    public ResponseEntity<DtoVerDetalleFactura> verDetalleFactura(@PathVariable int id){
        return servicioDetalleFactura.verDetalleFactura(id);
    }
}
