package com.ceiba.factura.controlador;

import com.ceiba.factura.modelo.entities.Factura;
import com.ceiba.factura.servicio.ServicioFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class ControladorFactura {

    @Autowired
    private ServicioFactura servicioFactura;

    @PostMapping("/registrar")
    public ResponseEntity<Factura> registrar(@RequestBody Factura factura){
        return servicioFactura.registrarFactura(factura);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable int id){
        return servicioFactura.buscarFacturaPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        return servicioFactura.eliminarFactura(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Factura>> listar(){
        return servicioFactura.listarFacturas();
    }
}