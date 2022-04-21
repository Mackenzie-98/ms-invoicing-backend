package com.ceiba.lote.controlador;

import com.ceiba.cliente.modelo.entities.Lote;
import com.ceiba.cliente.servicio.ServicioLote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotes")
@Api(tags = { "Controlador lote"})
public class ControladoLote {

    @Autowired
    private ServicioLote servicioLote;

    @PostMapping("/registrar")
    @ApiOperation("Registrar lote")
    public ResponseEntity<Lote> registrar(@RequestBody Lote lote){
        return servicioLote.registrarLote(lote);
    }

    @GetMapping("buscar/{id}")
    @ApiOperation("Buscar lote por id")
    public ResponseEntity buscar(@PathVariable int id){
        return servicioLote.buscarLotePorId(id);
    }

    @DeleteMapping("eliminar/{id}")
    @ApiOperation("Eliminar lote por id")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        return servicioLote.eliminarLote(id);
    }

    @GetMapping("/listar")
    @ApiOperation("Listar todos los lotes")
    public ResponseEntity<List<Lote>> listar(){
        return servicioLote.listarLotes();
    }
}
