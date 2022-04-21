package com.ceiba.factura.controlador;

import com.ceiba.Factura.servicio.ServicioFactura;
import com.ceiba.cliente.modelo.entities.Factura;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
@Api(tags = { "Controlador factura"})
public class ControladorFactura {

    @Autowired
    private ServicioFactura servicioFactura;

    @PostMapping("/registrar")
    @ApiOperation("Registrar factura")
    public ResponseEntity<Factura> registrar(@RequestBody Factura factura){
        return servicioFactura.registrarFactura(factura);
    }

    @GetMapping("buscar/{id}")
    @ApiOperation("Buscar factura por id")
    public ResponseEntity buscar(@PathVariable int id){
        return servicioFactura.buscarFacturaPorId(id);
    }

    @DeleteMapping("eliminar/{id}")
    @ApiOperation("Eliminar Factura por id")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        return servicioFactura.eliminarFactura(id);
    }

    @GetMapping("/listar")
    @ApiOperation("Listar todos los Facturas")
    public ResponseEntity<List<Factura>> listar(){
        return servicioFactura.listarFacturas();
    }
}
