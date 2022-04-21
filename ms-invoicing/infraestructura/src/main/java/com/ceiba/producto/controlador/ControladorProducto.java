package com.ceiba.producto.controlador;

import com.ceiba.cliente.modelo.entities.Producto;
import com.ceiba.cliente.servicio.ServicioProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Api(tags = { "Controlador producto"})
public class ControladorProducto {

    @Autowired
    private ServicioProducto servicioProducto;

    @PostMapping("/registrar")
    @ApiOperation("Registrar producto")
    public ResponseEntity<Producto> registrar(@RequestBody Producto producto){
        return servicioProducto.registrarProducto(producto);
    }

    @GetMapping("buscar/{id}")
    @ApiOperation("Buscar producto por id")
    public ResponseEntity buscar(@PathVariable int id){
        return servicioProducto.buscarProductoPorId(id);
    }

    @DeleteMapping("eliminar/{id}")
    @ApiOperation("Eliminar producto por id")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        return servicioProducto.eliminarProducto(id);
    }

    @GetMapping("/listar")
    @ApiOperation("Listar todos los productos")
    public ResponseEntity<List<Producto>> listar(){
        return servicioProducto.listarProductos();
    }
}
